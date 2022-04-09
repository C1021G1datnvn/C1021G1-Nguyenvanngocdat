function fibonacci(i: number): number {
    if (i <= 1) {
        return 1;
    }
    return  fibonacci(i - 1) + fibonacci(i -2);
}

let sum: number = 0;
    for (let i = 0; i < 15; i++) {
        console.log(fibonacci(i))
        sum += fibonacci(i)
    }
    console.log(`Tổng là: ${sum}`);

