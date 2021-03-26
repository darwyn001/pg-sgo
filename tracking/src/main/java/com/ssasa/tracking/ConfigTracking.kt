package com.ssasa.tracking

import android.view.View
import com.ssasa.tracking.pojo.Gestion

class ConfigTracking {
    var mainList: MutableList<Gestion> = mutableListOf()
    var activeDetailItem: View.OnClickListener? = null
    var urlDetails: String? = null

    fun addMainItems(newItems: MutableList<Gestion>): ConfigTracking {
        this.mainList.addAll(newItems)
        return this
    }

    fun setActiveDetailClickListener(itemClickListener: View.OnClickListener): ConfigTracking {
        this.activeDetailItem = itemClickListener
        return this
    }

    fun setUrlDetails(newUrl: String): ConfigTracking {
        this.urlDetails = newUrl
        return this
    }

    companion object {
        private var configTracking: ConfigTracking? = null

        fun getInstance(): ConfigTracking {
            if (configTracking == null)
                configTracking = ConfigTracking()

            return configTracking!!
        }
    }
}