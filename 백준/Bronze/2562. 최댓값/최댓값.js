const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");

let max = 0;
let idx = -1;
for (let i = 0; i < 9; i++) {
  if (max < Number(input[i])) {
    max = Number(input[i]);
    idx = i + 1;
  }
}

console.log(max);
console.log(idx);
