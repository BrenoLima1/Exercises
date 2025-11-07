<?php
function isPrimeNumber(int $number) : bool {
    if ($number <= 1) {
        return false;
    }

    for ($i=2; $i <= sqrt($number) ; $i++) {
        if ($number % $i == 0) {
            return false;
        }
    }

    return true;
}
for ($i=1; $i <= 10; $i++) {
    if (isPrimeNumber($i)){
        echo $i . "\n";
    }

}

?>
