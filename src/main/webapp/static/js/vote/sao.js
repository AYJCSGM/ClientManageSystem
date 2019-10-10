/**
 * 
 */
var row = 10; //行数
var col = 10; //列数
var maxCount = 10; //最大地雷数量
var isFirstOpen = true; //第一次打开方格
var grid = init_grid(); //初始化
var count = document.getElementById('count'); //剩余地雷数
count.innerHTML = maxCount; //初始化剩余雷数
var time = document.getElementById('time'); //计时器
var timer = setInterval(function() {
  let seconds = (parseFloat(time.innerHTML) + 0.1).toFixed(1); //保留一位小数
  time.innerHTML = seconds;
},
100) //定时器 100ms执行一次
//初始化矩阵 (row-行数 col-列数)
function init_grid() {

  //生成矩阵html <tr>--行标签 <td>--列标签
  let gridHtml = '';
  for (let i = 0; i < row; i++) {
    gridHtml += '<tr>'
    for (let j = 0; j < col; j++) {
      gridHtml += '<td><span class="blocks" onmousedown="block_click(' + i + ',' + j + ',event)"></span></td>';
    }
    gridHtml += '<tr>'
  }
  //写入html
  document.getElementById('grid').innerHTML = gridHtml;

  //返回矩阵二维数组
  let blocks = document.getElementsByClassName('blocks');
  let grid = new Array();
  for (let i = 0; i < blocks.length; i++) {
    if (i % col === 0) {
      grid.push(new Array());
    }
    //初始化计雷数
    blocks[i].count = 0;
    grid[parseInt(i / col)].push(blocks[i]);
  }
  return grid;
}

//方格点击事件 _i：坐标i _j:坐标j e:鼠标事件
function block_click(_i, _j, e) {

  //跳过已打开的方格
  if (grid[_i][_j].isOpen) {
    return;
  }

  //鼠标左键打开方格
  if (e.button === 0) {

    //第一次打开
    if (isFirstOpen) {

      isFirstOpen = false;
      let count = 0; //当前地雷数
      //生成地雷
      while (count < maxCount) {

        //生成随机坐标
        let ri = Math.floor(Math.random() * row);
        let rj = Math.floor(Math.random() * col);

        //坐标不等于第一次点击方格的坐标 && 非雷方格
        if (! (ri === _i && rj === _j) && !grid[ri][rj].isMine) {
          grid[ri][rj].isMine = true; //自定义属性isMine代表方格为地雷
          count++; //当前地雷数+1
          //更新九宫格内非雷方格的计雷数
          for (let i = ri - 1; i < ri + 2; i++) {
            for (let j = rj - 1; j < rj + 2; j++) {
              //判断坐标防越界
              if (i > -1 && j > -1 && i < row && j < col) {
                //计雷数+1
                grid[i][j].count++;
              }
            }
          }
        }
      }
    }

    //执行打开方格函数
    block_open(_i, _j);

    //打开方格函数
    function block_open(_i, _j) {

      let block = grid[_i][_j];
      op(block);

      //设定打开方格的状态与样式
      function op(block) {
        block.isOpen = true; //isOpen为自定义属性，设置为true代表已打开
        block.style.background = '#ccc'; //将背景设置为灰色
        block.style.cursor = 'default'; //将鼠标停留样式设置为默认
      }

      if (block.isMine) {
        //踩雷
        block.innerHTML = '雷'; //显示为 '雷'
        //遍历矩阵打开所有的地雷方格
        for (let i = 0; i < row; i++) {
          for (let j = 0; j < col; j++) {
            //找到地雷
            block = grid[i][j];
            if (!block.isOpen && block.isMine) {
              op(block); //设置打开状态和样式
              block.innerHTML = '雷'; //显示为 '雷'
            }
          }
        }
        clearInterval(timer); //游戏结束停止计时，清除定时器
        //提示游戏结束
        alert("游戏结束");
      } else if (block.count === 0) {
        //打开计雷数为0的方格
        //遍历九宫格内的方格
        for (let i = _i - 1; i < _i + 2; i++) {
          for (let j = _j - 1; j < _j + 2; j++) {
            //判断是否越界&&跳过已打开的方格&&非雷
            if (i > -1 && j > -1 && i < row && j < col && !grid[i][j].isOpen && !grid[i][j].ismine) {
              //递归打开方格函数
              block_open(i, j);
            }
          }
        }
      } else {
        //打开计雷数不为0的方格
        block.innerHTML = block.count; //显示计雷数
      }

    }
  }
  //鼠标右键标记方格
  else if (e.button === 2) {

    let block = grid[_i][_j];
    if (block.innerHTML !== '▲') {
      block.innerHTML = '▲';
    } else {
      block.innerHTML = '';
    }
  }

  //遍历矩阵
  let isWin = true;
  count.innerHTML = maxCount; //重置剩余地雷数
  for (let i = 0; i < row; i++) {
    for (let j = 0; j < col; j++) {
      let block = grid[i][j];

      //找到标记
      if (block.innerHTML === '▲') {
        count.innerHTML = parseInt(count.innerHTML) - 1; //剩余地雷数-1
      }

      //判断游戏胜利条件(所有的非雷方格已打开)
      if (!block.isMine && !block.isOpen) {
        //如果有未打开的非雷方块 条件不成立
        isWin = false;
      }
    }
  }
  if (isWin) {
    clearInterval(timer); //游戏胜利结束计时，清除定时器
    alert("游戏胜利");
  }
}