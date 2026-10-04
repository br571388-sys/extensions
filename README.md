---
title: My Music Bot
emoji: 🎵
colorFrom: blue
colorTo: purple
sdk: docker
app_port: 7860
pinned: false
---

# 🎵 Telegram Music Bot (Docker / Hugging Face ready)

A Telegram voice-chat music bot built on the open-source
[YukkiMusicBot](https://github.com/TeamYukki/YukkiMusicBot) (MIT License).

**What is different in this version**

- Runs on **MTProto** through Pyrogram, using your own `API_ID` and `API_HASH` (not the HTTP Bot API).
- **Docker ready** for Hugging Face Spaces (port `7860`, health-check server included).
- **All promotion is yours and controlled by secrets**: support channel, support group, repo button,
  chats the assistant auto-joins, and an extra `/start` message. Nothing from the original team is hard-coded anymore.
- The hidden shared MongoDB fallback was **removed**. You must give your own `MONGO_DB_URI`.
- Auto-update from the upstream repo is **off** unless you set `UPSTREAM_REPO`.

## Deploy on Hugging Face Spaces

1. Create a new Space and choose **Docker** as the SDK (Blank template).
2. Upload every file of this project to the Space (this `README.md` already has the required header).
3. Open **Settings → Variables and secrets** and add the values listed in [`SECRET.md`](SECRET.md).
   Put private values under **Secrets**, not Variables.
4. The Space builds and starts automatically. Check the **Logs** tab.

## Before the first start

- Create a **private log group**, add your bot **and** your assistant account, and make both admins.
- **Start a voice chat** in that log group and never end it (the bot checks it on boot).
- Generate the assistant's `STRING_SESSION` with `python genstring.py` on your own computer.

## Run locally with Docker

```bash
cp sample.env .env      # fill it in
docker build -t musicbot .
docker run --env-file .env -p 7860:7860 musicbot
```

## Notes

- Free Hugging Face Spaces can go to sleep after inactivity. Use an uptime pinger on your Space URL if needed.
- Streaming from YouTube on datacenter IPs can be rate-limited or blocked by YouTube. That is outside the bot's control.
- Respect Telegram's Terms of Service and the copyright rules of the content you stream.

## Credits

Based on YukkiMusicBot by Team Yukki (MIT License, see `LICENSE`). Modified for Docker/Hugging Face
deployment with configurable branding.
