from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

try:
    chrome_options = Options()
    driver = webdriver.Chrome(options=chrome_options)
    driver.get('http://localhost:8000/')
    driver.maximize_window()

    time.sleep(2)

    title_text = "Testing title text"
    content_text = "Testing content text"

    print("Testing started...\n")
    print("Testing Save functionality...")

    title = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//input[@placeholder='Title']")))
    title.send_keys(title_text)
    print("Title:", title_text)

    time.sleep(2)

    content = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//textarea[@placeholder='Content']")))
    content.send_keys(content_text)
    print("Content:", content_text)

    time.sleep(2)

    save_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.CSS_SELECTOR, "button[class='btn btn-primary m-0']")))
    save_button.click()

    time.sleep(2)

    print("Save functionality tested successfully...")

    driver.execute_script("window.scrollTo(0, document.body.scrollHeight)")
    time.sleep(2)

    print("\nTesting Edit functionality...")

    edit_title_text = "Testing edit title text"
    edit_content_text = "Testing edit content text"

    edit_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//article[last()]//button[@class='btn btn-warning m-1']")))
    edit_button.click()

    time.sleep(2)

    title = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//textarea[@placeholder='Title']")))
    title.send_keys(Keys.CONTROL + "a")
    title.send_keys(Keys.BACKSPACE)
    title.send_keys(edit_title_text)
    print("Edit Title:", edit_title_text)

    time.sleep(2)

    content = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//textarea[@placeholder='Content']")))
    content.send_keys(Keys.CONTROL + "a")
    content.send_keys(Keys.BACKSPACE)
    content.send_keys(edit_content_text)
    print("Edit Content:", edit_content_text)

    save_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.CSS_SELECTOR, "button[type='submit']")))
    save_button.click()

    time.sleep(2)

    print("Edit functionality tested successfully...")

    driver.execute_script("window.scrollTo(0, document.body.scrollHeight)")

    time.sleep(2)
    
    print("\nTesting Delete functionality...")
    
    delete_button = WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.XPATH, "//article[last()]//button[@class='btn btn-danger m-1']")))
    delete_button.click()
    
    print("Delete functionality tested successfully...")

except Exception as e:
    print("Testing failed...", e)

finally:
    print("\nTesting completed")
    time.sleep(2)