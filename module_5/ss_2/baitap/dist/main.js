let fibonacci = (num) => {
    if (num === 1 || num === 2) {
        return 1;
    }
    if (num >= 3) {
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
};
let sum = 0;
let printF = (num) => {
    for (let i = 1; i <= num; i++) {
        console.log(`số fibonacci thứ ${i} là : ` + fibonacci(i));
        sum += fibonacci(i);
    }
    console.log(`tổng ${num} số fibonacci đầu tiên là :` + sum);
};
printF(10);
//# sourceMappingURL=main.js.map