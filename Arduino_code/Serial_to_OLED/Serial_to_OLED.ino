#include <SPI.h>
#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

#include <Fonts/FreeMono9pt7b.h>  

Adafruit_SSD1306 display(128, 64);

String incomingString="";

void setup() 
{
    delay(100);
    display.begin(SSD1306_SWITCHCAPVCC, 0x3C);
    display.clearDisplay();
    display.setTextColor(WHITE);
    display.dim(0);
    Serial.begin(9600);
}

void loop() 
{
    display.clearDisplay();
    display.setTextColor(WHITE, BLACK);
    display.setTextSize(1);
    display.setCursor(0,0);

    int fanSpeed[] = {0,0,0,0,0,0};
  
    if( Serial.available( ) ){
        incomingString = Serial.readString( );
        if(!incomingString.startsWith("#set:"))
            {display.println(incomingString);
            display.display();}
        else {
          String temp = "";
            for(int i=5,j=0; i<incomingString.length();i++)
            {              
                if(incomingString.charAt(i)!=',')
                {
                    temp += incomingString.charAt(i);
                }
                else{ fanSpeed[j] = temp.toInt();
                temp = "";j++;
 }

                
            }
            display.println(fanSpeed[0]);
            display.display();

        }
    }
}
