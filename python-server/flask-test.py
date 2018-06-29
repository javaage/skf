from flask import Flask
from a import method_test

app = Flask(__name__)

@app.route("/")
def hello():
    return method_test()

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=8888, debug=True)