package com.example.android.guesstheword.screens.game

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class GameViewModel: ViewModel() {

    val word = MutableLiveData<String>()
    val score = MutableLiveData<Int>()
    private lateinit var wordList: MutableList<String>
    private fun  resetList() {
        wordList = mutableListOf("queen","hospital","basketball","cat","cahnge","snail","guitar","desk","railway","bubble")
        wordList.shuffle()
    }

    init {
        word.value = ""
        score.value = 0
        resetList()
        nextWord()
    }


    private fun nextWord() {
        if (!wordList.isEmpty()) {
            //Select and remove a word from the list
            word.value = wordList.removeAt(0)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("GameViewModel destroyed!")
    }



    fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        score.value = (score.value)?.plus(1)
        nextWord()
    }
}