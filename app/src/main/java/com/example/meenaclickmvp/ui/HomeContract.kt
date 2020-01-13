package com.example.meenaclickmvp.ui

import com.example.meenaclickmvp.model.CatalogProductsItem

class HomeContract {
    interface View{
        fun setDataIntoAdapter(list: ArrayList<CatalogProductsItem>)
    }

    interface Presenter{
        fun receivedApiData()
    }

}