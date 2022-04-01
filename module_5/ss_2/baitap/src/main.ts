let fibonacci = (num: number): number => {
    if (num <= 1) {
        return num;
    }else {
        return fibonacci(num -1 + fibonacci(num - 2));
    }
}

let sum: number = 0
let printF = (num: number): void => {
    for (let i = 1; i <= num; i++) {
        console.log(`số fibonacci thứ ${i} là : `+fibonacci(i))
        sum += fibonacci(i)
    }
    console.log(`tổng ${num} số fibonacci đầu tiên là :` + sum)
}

printF(10)
