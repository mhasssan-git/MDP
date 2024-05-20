package com.miu.animalkingdomexplorer.ui

public interface OnAddListener<Data> {
    suspend fun saveData(data:Data)
}