class Conta(
    val titular: String,
    var numero: String,
    val gerente: String = "Default"
) {
    //    var titular = titular
//    var numero = numero
    var saldo = 0.0
        private set

//    constructor(titular: String, numero: String){
//        this.titular = titular
//        this.numero = numero
//    }


    fun deposita(valor: Double) {
        println("Depositando na Conta do ${this.titular}")

        if (valor < 0) println("Valor atribuido não pode ser negativo")
        else {
            this.saldo += valor
            println("Novo saldo da conta de ${this.titular}: ${this.saldo}")
        }

    }

    fun saca(valor: Double) {
        println("Sacando da Canto do ${this.titular}")
        when {
            this.saldo < valor -> println("Não foi possivel sacar. Saldo insuficiente!")
            else -> {
                this.saldo -= valor
                println("Novo saldo da conta de ${this.titular}: ${this.saldo}")
            }
        }
    }

    fun tranfere(valor: Double, contaDestino: Conta): Boolean {

        if (this.saldo < valor) return false

        this.saca(valor)
        contaDestino.deposita(valor)

        return true
    }

//    fun getSaldo(): Double{
//        return this.saldo
//    }
//
//    fun setSaldo(valor: Double){
//        if(valor < 0) println("Valor atribuido não pode ser negativo")
//        else this.saldo = valor
//    }

}

fun main() {
    println("Bem vindo ao Bytebank")

//    testaCondicoes(saldo)
//    testaLacos()

//    val conta = Conta()
//    conta.titular = "DouG"
//    conta.numero = "14222-0"
//    conta.saldo = 91000.00
//
//    println(conta.titular)
//    println(conta.numero)
//    println(conta.saldo)

//    testaCopiasEReferencias()

    var contaJose = Conta(titular = "Jose", gerente = "Nestor", numero = "0001")
    contaJose.deposita(-500.00)
    println(contaJose.gerente)

    var contaMaria = Conta(numero = "0002", titular = "Maria")
    contaMaria.deposita(900.00)
    println(contaMaria.gerente)

    contaJose.deposita(300.00)

    contaMaria.deposita(780.00)

    contaJose.saca(800.00)

    contaMaria.saca((1600).toDouble())

    if (contaMaria.tranfere(contaDestino = contaJose, valor = 80.0)) println("Transferência realizada com sucesso!")
    else println("Um erro foi encontrado na operação de transferência!")

    println(contaJose.numero)
    contaJose.numero = "1110"
    println(contaMaria.saldo)
    println(contaJose.numero)

}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY = 50

    println(numeroX)
    println(numeroY)

    var contaJose = Conta("Jose", "0001")
    contaJose.numero = "0001"
    contaJose.deposita(500.00)

    var contaMaria = Conta("Maria", "0002")
    contaMaria.numero = "0002"
    contaMaria.deposita(900.00)

    println(contaJose.titular)
    println(contaMaria.titular)

}

fun testaCondicoes(saldo: Double) {
    when {
        saldo > 0.0 -> println("Conta positiva")
        saldo == 0.0 -> println("Conta zerada")
        else -> println("Conta negativa")
    }
}

fun testaLacos() {
    for (i in 5 downTo 1 step 2) {

        if (i == 3) continue

        val titular = "DouG $i"
        val numeroConta: Int = 9223 + i
        var saldo: Double = 0.0

        saldo = 100 + 500.0
        saldo += 20

        println("Titular da conta $titular")
        println("Numero da conta $numeroConta")
        println("Saldo da conta $saldo")
        println()
    }

    var i = 1;

    while (i <= 5) {
        val titular = "DouG $i"
        val numeroConta: Int = 9223 + i
        var saldo: Double = 0.0

        saldo = 100 + 500.0
        saldo += 20

        println("Titular da conta $titular")
        println("Numero da conta $numeroConta")
        println("Saldo da conta $saldo")
        println()

        i++
    }

    do {
        val titular = "DouG $i"
        val numeroConta: Int = 9223 + i
        var saldo: Double = 0.0

        saldo = 100 + 500.0
        saldo += 20

        println("Titular da conta $titular")
        println("Numero da conta $numeroConta")
        println("Saldo da conta $saldo")
        println()

        i++
    } while (i <= 5)

    loopExterno@ for (i in 1..100) {
        println("i $i")

        for (j in 1..100) {
            println("j $j")

            if (j == 50) break@loopExterno
        }
    }
}