function drawTriangle(linhas: number): void {
  for (let i = 1; i <= linhas; i++) {
    const espacos = " ".repeat(linhas - i);
    const estrelas = "*".repeat(2 * i - 1);
    console.log(espacos + estrelas);
  }
}

drawTriangle(5);
