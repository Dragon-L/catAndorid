package com.example.glliao.catandorid.model

class NearbyCatResponse {
    var moments: List<MomentsBean>? = null

    class MomentsBean {

        var id: String? = null
        var cat: String? = null
        var avatar: CatImage? = null
        var timestamp: String? = null
        var message: String? = null
        var thumbs: List<CatImage>? = null

        class CatImage {
            var image: String? = null
        }
    }

}