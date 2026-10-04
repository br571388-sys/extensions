# 🔐 SECRET.md - Variables & Secrets guide

On Hugging Face: **Space → Settings → Variables and secrets → New secret**.
Never write real values inside code, `README.md`, or any file you upload. Your Space repo can be public.

## Required (bot will not start without these)

| Name | What it is | Where to get it |
|---|---|---|
| `API_ID` | Telegram API ID (number) | https://my.telegram.org → API development tools |
| `API_HASH` | Telegram API hash | same page |
| `BOT_TOKEN` | Your bot token | @BotFather |
| `MONGO_DB_URI` | Your own MongoDB connection string | MongoDB Atlas (free cluster). Allow access from `0.0.0.0/0` |
| `LOG_GROUP_ID` | ID of your private log group, like `-1001234567890` | Add a bot such as @MissRose_bot / @userinfobot to read the ID |
| `MUSIC_BOT_NAME` | Bot name, plain ASCII only | Your choice |
| `OWNER_ID` | Your Telegram user ID (several IDs separated by space) | @userinfobot |
| `STRING_SESSION` | Assistant account Pyrogram v1 string session | Run `python genstring.py` locally |

Optional extra assistants: `STRING_SESSION2` … `STRING_SESSION5`.

## Promotion secrets (all optional, these are yours)

| Name | Effect | Example |
|---|---|---|
| `SUPPORT_CHANNEL` | Shows a **Channel** button on start panels | `https://t.me/mychannel` |
| `SUPPORT_GROUP` | Shows a **Support** button on start panels | `https://t.me/mygroup` |
| `GITHUB_REPO` | Shows a **Git Repo** button | `https://github.com/me/musicbot` |
| `ASSISTANT_JOIN_CHATS` | Chats your assistant account(s) auto-join on every start (space or comma separated) | `mychannel mygroup` |
| `PROMO_TEXT` | Extra text under the `/start` message in private and in groups | `Join @mychannel for updates!` |
| `START_IMG_URL` | Picture shown on private `/start` (direct https link) | `https://.../banner.jpg` |

Links must start with `https://`. Leave a variable empty and that promo simply does not show.

## Optional bot settings

| Name | Default | Meaning |
|---|---|---|
| `SPOTIFY_CLIENT_ID` / `SPOTIFY_CLIENT_SECRET` | none | Enables Spotify links |
| `DURATION_LIMIT` | `60` | Max track length in minutes |
| `AUTO_LEAVING_ASSISTANT` | off | Set `True` to make the assistant leave idle chats |
| `ASSISTANT_LEAVE_TIME` | `5400` | Seconds before leaving |
| `AUTO_SUGGESTION_MODE` | off | Set `True` for random command tips in chats |
| `PRIVATE_BOT_MODE` | off | Set `True` so only chats you authorise can use the bot |
| `SET_CMDS` | off | Set `True` to auto-create the bot's command menu |
| `VIDEO_STREAM_LIMIT` | `3` | Max simultaneous video calls |
| `UPSTREAM_REPO` / `UPSTREAM_BRANCH` / `GIT_TOKEN` | empty / `master` | Only if you want auto-update from **your own** repo |
| `PORT` | `7860` | Health-check port (keep default on Hugging Face) |

## Safety tips

- Anyone with `STRING_SESSION` can control the assistant account. Use a spare account, not your main one.
- If a secret ever leaks, rotate it: revoke the bot token in @BotFather, terminate the session in Telegram → Settings → Devices, change the MongoDB password.
