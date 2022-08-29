package com.my.assignment.models

data class FlatDetailsModel(

    var cards: ArrayList<Cards> = arrayListOf(),

    )

data class Type(

    var name: String? = null,
    var id: String? = null,

    )

data class SubInfo(

    var text: String? = null,

    )

data class AssignedTo(

    var uuid: String? = null,
    var profile_pic_url: String? = null,
    var phone_number: String? = null,
    var org_name: String? = null,
    var name: String? = null,

    )


data class MainPost(

    var uuid: String? = null,
    var type: Type? = Type(),
    var title: String? = null,
    var sub_info: ArrayList<SubInfo> = arrayListOf(),
    var post_uuid: String? = null,
    var max_budget: Int? = null,
    var match_count: Int? = null,
    var info: String? = null,
    var assigned_to: AssignedTo? = AssignedTo(),

    )


data class HorizontalCards(

    var uuid: String? = null,
    var type: Type? = Type(),
    var title: String? = null,
    var sub_info: ArrayList<SubInfo> = arrayListOf(),
    var price: Int? = null,
    var post_uuid: String? = null,
    var info: String? = null,
    var assigned_to: AssignedTo? = AssignedTo(),

    )

data class Data(

    var total_matches_count: Int? = null,
    var main_post: MainPost? = MainPost(),
    var horizontal_cards: ArrayList<HorizontalCards> = arrayListOf(),

    )


data class Cards(

    var data: Data? = Data(),

    )