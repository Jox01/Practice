#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>

int main(int argc, char **argv)
{
 	char buf[1024];

    while(fgets(buf, 1024, stdin) != NULL) {
        
        for(int i= 0; buf[i] != '\0'; ++i){
            buf[i] = toupper(buf[i]);
        }

        fprintf(stdout,"%s\n",buf);
        fflush(stdout); // IMP: para asegurar que se reciben los datos
    }
 	
 exit(0);
}