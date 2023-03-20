fun main() {
    val payment: Int = 80000
    val totalMonthPayments = 1000
    val dailyLimits: Int = 150_000
    val monthlySend: Int = 600_000
    val monthlyReceive: Int = 600_000
    val paymentMethod: String = "Mastercard"
    println(comissionCalculate(paymentAmount = payment, paymentMethod = paymentMethod))

}
fun comissionCalculate (
    paymentMethod: String = "VK Pay",
    totalMonthPayments: Int = 10_000,
    paymentAmount: Int
): Float {
val comission: Float = when (paymentMethod) {
    "VK Pay" -> vkPay(paymentAmount, totalMonthPayments)
    "Visa"-> visaMir(paymentAmount)
    "Мир" ->visaMir(paymentAmount)
    "Maestro" -> masterkardMaestro(paymentAmount)
    "Mastercard" -> masterkardMaestro(paymentAmount)
    else -> 0.00F
    }
    return comission
}
fun visaMir(amount :Int): Float {
    val minAmount: Int = 35 //Минимальный перевод в рублях
    val comission: Float = 0.75F //Процент комиссии
    val fee: Float = if (amount > minAmount) amount/100*comission else 0.00F  //Если перевод больше 35 рублей то считаем комиссию, иначе комиссия = 0
    return fee
}
fun masterkardMaestro (amount: Int): Float {
    val promotion: Boolean = true
    val fee: Float = if((amount in 300..75000)&&promotion) 0.00F else ((amount/1000)*6+20).toFloat()
    return fee
}
fun vkPay(amount: Int, totalMonthPayments: Int): Float {           //Доступен ли платеж через VKpay
    val maxSend: Int = 15_000
    val maxSendMonth: Int = 40_000
    return if ((amount<=maxSend) && (totalMonthPayments<=maxSendMonth)) 0.00F
    else 0.00F
}