#
# Tiny health-check web server so Hugging Face Docker Spaces
# (and uptime pingers) see the app as "running".
# It uses only the standard library and runs in a background thread.
#

import os
import threading
from http.server import BaseHTTPRequestHandler, HTTPServer


class _Handler(BaseHTTPRequestHandler):
    def do_GET(self):
        body = b"Music bot is running."
        self.send_response(200)
        self.send_header("Content-Type", "text/plain; charset=utf-8")
        self.send_header("Content-Length", str(len(body)))
        self.end_headers()
        self.wfile.write(body)

    def do_HEAD(self):
        self.send_response(200)
        self.end_headers()

    def log_message(self, *args):
        pass


def start_health_server():
    port = int(os.getenv("PORT", "7860"))
    try:
        server = HTTPServer(("0.0.0.0", port), _Handler)
    except OSError:
        return
    threading.Thread(target=server.serve_forever, daemon=True).start()
