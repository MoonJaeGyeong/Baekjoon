fun main(){
    val n = readLine()!!.toInt()
    var paper = Array(100,{IntArray(100)})
    var answer = 0

    for(i in 0 until n){
        val tmp = readln().split(" ")
        for(j in tmp[0].toInt() until tmp[0].toInt() + 10){
            for(k in tmp[1].toInt() until tmp[1].toInt() + 10){
                paper[j][k] = 1
            }
        }
    }

    for(i in 0 until 100){
        for(j in 0 until 100){
            answer += paper[i][j]
        }
    }

    println(answer)
}