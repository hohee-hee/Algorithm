const fs = require("fs");
const filePath = process.platform === "linux" ? "dev/stdin" : "input.txt";
const input = fs.readFileSync(filePath).toString().trim().split("\n");
const inputN = Number(input[0]);
const inputLine = [];
for (let i = 0; i < input.length; i++) {
  let yut = 0;
  input[i]
    .toString()
    .trim()
    .split(" ")
    .forEach((e) => {
      e === "0" && yut++;
    });
  switch (yut) {
    case 1:
      console.log("A");
      break;
    case 2:
      console.log("B");
      break;
    case 3:
      console.log("C");
      break;
    case 4:
      console.log("D");
      break;
    default:
      console.log("E");
      break;
  }
}
