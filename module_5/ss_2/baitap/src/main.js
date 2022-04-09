function fibonacci(i) {
    if (i <= 1) {
        return 1;
    }
    return fibonacci(i - 1) + fibonacci(i - 2);
}
var sum = 0;
for (var i = 0; i < 15; i++) {
    console.log(fibonacci(i));
    sum += fibonacci(i);
}
console.log("T\u1ED5ng l\u00E0: ".concat(sum));
