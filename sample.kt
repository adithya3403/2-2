/*
n=int(input())
player_score={}
player_average={}
count={}
for i in range(n):
    player_number, score=map(int, input().split())
    if player_number in player_score:
        player_score[player_number]+=score
        count[player_number]+=1
    else:
        player_score[player_number]=score
        count[player_number]=1
for key, value in player_score.items():
    player_average[key]=value/count[key]
player_average=sorted(player_average.items(), key=lambda x:x[0])
for key, value in player_average:
    print(key, int(value))
*/

import java.util.*;
fun main() {
    val n = readLine()!!.toInt()
    val playerScore = mutableMapOf<Int, Int>()
    val playerAverage = mutableMapOf<Int, Int>()
    val count = mutableMapOf<Int, Int>()
    for (i in 1..n) {
        val (playerNumber, score) = readLine()!!.split(" ").map { it.toInt() }
        if (playerScore.containsKey(playerNumber)) {
            playerScore[playerNumber] = playerScore[playerNumber]!! + score
            count[playerNumber] = count[playerNumber]!! + 1
        } else {
            playerScore[playerNumber] = score
            count[playerNumber] = 1
        }
    }
    for (key in playerScore.keys) {
        playerAverage[key] = playerScore[key]!! / count[key]
    }
    playerAverage.toList().sortedBy { it.first }.forEach {
        println("${it.first} ${it.second.toInt()}")
    }
}