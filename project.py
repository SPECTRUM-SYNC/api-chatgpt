# Import the necessary modules
import openai

# Define your OpenAI API key and URL
openai.api_key = "YOUR_OPENAI_API_KEY"
openai.api_base = "https://api.openai.com/v1"

# Define the user message
user_message = "Hello ChatGPT!"

# Use the correct endpoint for chat models
chatgpt_response = openai.ChatCompletion.create(
    model="gpt-3.5-turbo-0613",
    messages=[
        {
            "role": "user",
            "content": user_message
        }
    ]
)

# Print the results
print(f"User: {user_message}")
print(f"ChatGPT: {chatgpt_response.choices[0].message.content}")