fun main(){
    var answer = ""
    val arr = ArrayList<String>()
    var length = 0

    for(i in 0..4){
        arr.add(readln())
        if(length < arr.get(i).length){
            length = arr.get(i).length
        }
    }

    for(i in 0..length){
        for(j in 0 .. 4){
            if(arr.get(j).length > i){
                answer += arr.get(j).get(i)
            }
        }
    }
    println(answer)
}