# ✅ CONFIRM_SECRET.md - Ye 8 secrets COMPULSORY hain

Hugging Face: **Space → Settings → Variables and secrets → New secret**

Inme se ek bhi missing hua to bot start nahi hoga.

| # | Name | Kya dena hai | Kahan se milega |
|---|------|--------------|-----------------|
| 1 | `API_ID` | Telegram API ID (number) | https://my.telegram.org → API development tools |
| 2 | `API_HASH` | Telegram API hash | same page |
| 3 | `BOT_TOKEN` | Bot ka token | @BotFather |
| 4 | `MONGO_DB_URI` | Tumhara apna MongoDB link | MongoDB Atlas (free). Network Access mein `0.0.0.0/0` allow karo |
| 5 | `LOG_GROUP_ID` | Private log group ki ID, jaise `-1001234567890` | Group mein ID bot (@userinfobot / @MissRose_bot) add karke |
| 6 | `MUSIC_BOT_NAME` | Bot ka naam, sirf simple English letters | Apni marzi |
| 7 | `OWNER_ID` | Tumhari Telegram user ID (kai ho to space se alag) | @userinfobot |
| 8 | `STRING_SESSION` | Assistant account ki Pyrogram string session | Apne computer par `python genstring.py` |

## Start se pehle ye 3 kaam zaroor

1. Private **log group** banao, usme bot aur assistant account dono ko add karke **admin** banao.
2. Us log group mein **voice chat start** karo aur kabhi band mat karna.
3. `STRING_SESSION` ke liye spare account use karo, main account nahi.

## Secret vs Variable

`API_HASH`, `BOT_TOKEN`, `MONGO_DB_URI`, `STRING_SESSION` ko hamesha **Secret** mein daalo, Variable mein nahi.

## Ye khali chhod do

`UPSTREAM_REPO`, `UPSTREAM_BRANCH`, `GIT_TOKEN`, `HEROKU_API_KEY`, `HEROKU_APP_NAME` - Hugging Face par inki zarurat nahi.

Promotion wale secrets (`SUPPORT_CHANNEL`, `SUPPORT_GROUP`, `PROMO_TEXT` etc.) optional hain, unki list `SECRET.md` mein hai.
