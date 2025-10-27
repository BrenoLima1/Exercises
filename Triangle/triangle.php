<?php
$height = 5;

for ($i = 1; $i <= $height; $i++) {
    $espacos = $height - $i;
    $estrelas = 2 * $i - 1;
    echo str_repeat(' ', $espacos) . str_repeat('*', $estrelas) . PHP_EOL;
}
