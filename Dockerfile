# Docker image for Hugging Face Spaces (SDK: docker) - also works anywhere else
FROM nikolaik/python-nodejs:python3.9-nodejs18

RUN apt-get update -y \
    && apt-get install -y --no-install-recommends ffmpeg git \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Hugging Face runs the container as user 1000, so keep the app folder writable
WORKDIR /app
ENV HOME=/tmp \
    PORT=7860 \
    PYTHONUNBUFFERED=1

COPY requirements.txt .
RUN pip3 install --no-cache-dir --upgrade pip \
    && pip3 install --no-cache-dir --upgrade -r requirements.txt

COPY . /app/
RUN mkdir -p /app/downloads /app/cache && chmod -R 777 /app

EXPOSE 7860
CMD ["bash", "start"]
