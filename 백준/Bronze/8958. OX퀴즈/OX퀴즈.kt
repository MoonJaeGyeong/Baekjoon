fun main(){
    val n = readLine()!!.toInt()

    for(i in 0 until n){
        val str = readLine()
        var answer = 0
        var score = 1
        for(j in 0 until str!!.length){
            if(str.get(j) == 'O'){
                answer += score
                score++
            }

            if(str.get(j) == 'X'){
                score = 1
            }
        }
        println(answer)
    }

}