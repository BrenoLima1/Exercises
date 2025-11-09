<?php

class Calculator
{
    public function add($a, $b)
    {
        return $a + $b;
    }

    public function subtract($a, $b)
    {
        return $a - $b;
    }

    public function multiply($a, $b)
    {
        return $a * $b;
    }

    public function divide($a, $b)
    {
        if ($b == 0) {
            throw new DivisionByZeroError("Division by zero is not allowed.");
        }
        return $a / $b;
    }


}

echo "Calculator! \n";

$calculator = new Calculator();

echo 'Select an operator ( + , - , * , /, q( to quit) ) : ';
$operator = trim(fgets(STDIN));

if ($operator == 'q') {
    exit('Goodbye!');
}

echo 'Enter first number : ';
$a = trim(fgets(STDIN));

echo 'Enter second number : ';
$b = trim(fgets(STDIN));

switch ($operator) {
    case '+':
        echo $a . ' + ' . $b . ' = ' . $calculator->add($a, $b);
        break;
    case '-':
        echo $a . ' - ' . $b . ' = ' . $calculator->subtract($a, $b);
        break;
    case '*':
        echo $a . ' * ' . $b . ' = ' . $calculator->multiply($a, $b);
        break;
    case '/':
        echo $a . ' / ' . $b . ' = ' . $calculator->divide($a, $b);
        break;
    default:
        echo 'Invalid operator';
        break;
}

?>
