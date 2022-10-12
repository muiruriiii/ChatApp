package com.android.chatapp


import com.android.chatapp.GroupMembers.Members as Users

object TextMessages {
    val groupConversation = listOf<TextMessage>(
        TextMessage(
            Users[0],
            "Heeyy guys\n" +
                    "Welcome to the group!"
        ),
        TextMessage(
            Users[1],
            "Thankss Mary"
        ),
        TextMessage(
            Users[2],
            "Thank You!.\nHow has your week been like?"
        ),
        TextMessage(
            Users[0],
            "It's been great, can't complain.\nWaiting for the weekend!."
        ),
        TextMessage(
            Users[1],
            "Mine has been exhausting waahh!and you?\n" +
                    "Sherehe tutapiga hii weekend!"
        ),
        TextMessage(
            Users[2],
            "Lazimaaa. My week has been okay pia"
        ),
        TextMessage(
            Users[0],
            "Where are we meeting up this Saturday?"
        ),
        TextMessage(
            Users[1],
            "We do the mini golf"
        ),
        TextMessage(
            Users[0],
            "Ahh the one at Village Market?\n" +
                    "I've heard it gets monotonous at times lakini :/"
        ),
        TextMessage(
            Users[0],
            "But we can give it a try, why not"
        ),
        TextMessage(
            Users[2],
            "It sounds like an interesting plan ama we go for iceskating?"
        ),
        TextMessage(
            Users[1],
            "By the wayy skating could work.At panari right?"
        ),
        TextMessage(
            Users[0],
            "Yahh! plus we all stay along Mombasa rd it's easily accessible for sure!"
        ),
        TextMessage(
            Users[2],
            "Perfectt! I also saw they have a photobooth, we can try it out."
        ),
        TextMessage(
            Users[1],
            "I'm already in love with the idea. Okay guys see you on Saturday!"
        ),
        TextMessage(
            Users[0],
            "See youu!"
        )
    )
}