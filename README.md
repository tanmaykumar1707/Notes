# Notes



import cv2
import time

def list_cameras():
    index = 0
    while True:
        cap = cv2.VideoCapture(index)
        if not cap.read()[0]:
            break
        cap.release()
        index += 1
    return index

num_cameras = list_cameras()
print(f"Number of cameras found: {num_cameras}")

for index in range(num_cameras):
    cap = cv2.VideoCapture(index)
    if cap.read()[0]:
        ret, frame = cap.read()
        cv2.imshow(f"Camera {index}", frame)
        cv2.waitKey(5000)  # Show for 5 seconds
        cv2.destroyAllWindows()
        cap.release()
    else:
        print(f"Unable to open camera {index}")

cv2.destroyAllWindows()