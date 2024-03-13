const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

input.sort((a, b) => a - b);

let avg = 0;
input.forEach((e) => (avg += Number(e)));
console.log(avg / 5);
console.log(input[2]);
