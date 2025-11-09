import Calculator from "./Calculator";
import * as readline from "readline";

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const calculator = new Calculator();

rl.question("Select an operation ( + , - , * , /, q to quit ): ", (operation: string) => {
  if (operation === "q") {
    rl.close();
    return;
  }

  rl.question("Enter the first number: ", (firstInput: string) => {
    const a = parseFloat(firstInput);

    rl.question("Enter the second number: ", (secondInput: string) => {
      const b = parseFloat(secondInput);

      let result: number;

      switch (operation) {
        case "+":
          result = calculator.add(a, b);
          break;
        case "-":
          result = calculator.subtract(a, b);
          break;
        case "*":
          result = calculator.multiply(a, b);
          break;
        case "/":
          result = calculator.divide(a, b);
          break;
        default:
          console.log("Invalid operation");
          rl.close();
          return;
      }

      console.log(`Result: ${result}`);
      rl.close();
    });
  });
});
