/**
 * 
 */ 
(function reset() {
    var oTa = document.createElement('table');
    var oTb = document.createElement('tbody');
    var index = 0;
    var snakeMove = null;
    var timer = null;
    for (var i = 0; i < 40; i++) {
        var oTr = document.createElement('tr');
        for (var j = 0; j < 40; j++) {
            var oTd = document.createElement('td');
            oTd.style.cssText = 'width:10px; height:10px; padding:0; border: 2p solid #ccc; background: #ccc;';
            oTr.appendChild(oTd);
        }
        oTb.appendChild(oTr);
    }
    oTa.appendChild(oTb);
    oTa.style.cssText = 'margin:60px auto 0; border:10px solid #333; background:#ccc;';
    document.body.appendChild(oTa);
    oTa.cellSpacing = '2 ';
    var aTd = oTb.getElementsByTagName('td');
    fruit();

    function fruit() {
        var num = Math.floor(Math.random() * aTd.length);
        if (num != index) {
            index = num;
            aTd[index].style.cssText = 'border: 2px solid #333; background: red;';
        } else {
            fruit();
        }
    }

    snake();

    function snake() {
        var rows = oTb.rows;
        var arr = []
        litleSnake();

        function litleSnake() {
            var ini = rows.length / 2 - 1;
            arr = [[ini, ini + 1]]
            snakeColor(arr);
        }

        function snakeColor(arr) {
            for (var i = 1; i < arr.length; i++) {
                rows[arr[i][0]].cells[arr[i][1]].style.cssText = 'background: #555; border: 2px solid #333;';
            }
            rows[arr[0][0]].cells[arr[0][1]].style.cssText = 'background: #eee; border: 2px solid #333;';
        }

        var json = {
            left: {key: true, timer: null},
            up: {key: true, timer: null},
            right: {key: true, timer: null},
            down: {key: true, timer: null}
        };
        var aDir = [];
        document.onkeydown = function (ev) {
            var ev = ev || event;
            for (var i = 37; i < 41; i++) {
                if (ev.keyCode == i && ev.keyCode != aDir[0]) {
                    aDir.unshift(ev.keyCode);
                    break;
                }
            }
            aDir.length = 2;
            if (Math.abs(aDir[0] - aDir[1]) == 2) return;
            switch (ev.keyCode) {
                case 32:
                    timer ? (function () {
                        clearInterval(timer);
                        timer = null;
                    })() : snakeMove && snakeMove();
                    break;
                case 37:
                    if (!json.left.key) return;
                    onOff('left');
                    fnTimer('left', 0, -1);
                    break;
                case 38:
                    if (!json.up.key) return;
                    onOff('up');
                    fnTimer('up', -1, 0);
                    break;
                case 39:
                    if (!json.right.key) return;
                    onOff('right');
                    fnTimer('right', 0, 1);
                    break;
                case 40:
                    if (!json.down.key) return;
                    onOff('down');
                    fnTimer('down', 1, 0);
                    break;
            } //switch
        }; //onkeydown
        function onOff(dir) {
            for (var i in json) {
                if (i == dir) {
                    json[i].key = false;
                } else {
                    json[i].key = true;
                    clearInterval(timer);
                }
            }
        }

        function fnTimer(dir, m, n) {
            snakeMove = function () {
                fnTimer(dir, m, n)
            };
            timer = setInterval(function () {
                if (arr[0][0] + m < 0 || arr[0][1] + n < 0 || arr[0][0] + m > 39 || arr[0][1] + n > 39) {
                    clearInterval(timer);
                    fail();
                    return;
                }
                for (var i = 2; i < arr.length; i++) {
                    if (arr[0][0] + m == arr[i][0] && arr[0][1] + n == arr[i][1]) {
                        clearInterval(timer);
                        fail();
                    }
                }
                arr.unshift([arr[0][0] + m, arr[0][1] + n]);
                if (rows[arr[0][0]].cells[arr[0][1]].style.backgroundColor != 'red') {
                    snakeTail();
                } else {
                    fruit();
                }
            }, 100);
        }

        function fail() {
            alert("GAME OVER");
            document.body.removeChild(oTa);
            reset();
        }

        function snakeTail() {
            rows[arr[arr.length - 1][0]].cells[arr[arr.length - 1][1]].style.cssText = 'background: #ccc; border: 2px solid #ccc;';
            arr.pop(arr[arr.length - 1]);
            snakeColor(arr);
        }
    }

    !window.pop && (function () {
    	alert("按空格键开始/暂停游戏");
        window.pop = 1;
    })()
})();