package com.israel.app.miadaptador

fun doAsync(x: Int, callBack: (String) -> Unit) {
    callBack.invoke("Finished")
}

fun test() {
    doAsync(20) {result -> print(result)}
}