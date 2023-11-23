import hashlib
import json
from flask import Flask, render_template, request, session

app = Flask(__name__)
app.secret_key = 'your_secret_key'  # Set a secret key for session encryption

@app.route('/')
def login():
    return render_template('login.html')

@app.route('/home')
def home():
    return render_template('index.html')

@app.route('/submit', methods=['GET'])
def handle_submit():
    data = request.args.get('data')

    # Store the data in the session
    session['data'] = data

    # Return a response
    return "Data received successfully!"

@app.route('/music/playlists', methods=['GET'])
def get_data():
    # Retrieve the data from the session
    data = session.get('data')

    # Process or use the data as needed
    if data:
        # Do something with the data
        return data
    else:
        return "No data"

if __name__ == '__main__':
    app.run()