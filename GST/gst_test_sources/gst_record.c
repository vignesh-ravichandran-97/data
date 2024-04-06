#include <stdio.h>
#include <stdlib.h>

int main() {
    const char* filePath = "/root/fw/test/audio_test/record_files";
    const char* soundCard = "alsasrc device=hw:1,0";
    char command[256];

    // Construct the GStreamer command
      snprintf(command, sizeof(command), "gst-launch-1.0 %s ! audioconvert ! audioresample ! volume volume=2.0 ! lamemp3enc ! filesink location=%s/record.mp3", soundCard,filePath);

    // Execute the GStreamer command
    int result = system(command);

    // Check if the command executed successfully
    if (result == 0) {
        return 0; // Success
    } else {
        return 1; // Error
    }
}

