#include <stdio.h>
#include <stdlib.h>

int main() {
    const char* filePath = "/root/fw/test/audio_test/record_files/record.mp3";
    const char* soundCard = "alsasink device=hw:2,0";
    char command[256];

    // Construct the GStreamer command
     snprintf(command, sizeof(command), "gst-launch-1.0 filesrc location=%s ! decodebin ! audioconvert ! volume volume=2.0 ! %s",filePath,soundCard);

    // Execute the GStreamer command
    int result = system(command);

    // Check if the command executed successfully
    if (result == 0) {
        return 0; // Success
    } else {
        return 1; // Error
    }
}

