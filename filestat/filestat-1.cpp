//Importing Libraries
#include <iostream>
#include <sys/stat.h>
#include <sys/types.h>
#include <time.h>
#include <pwd.h>

using namespace std;

/*
This program takes in a file through the command line and outputs related statistics.
*/
int main (int argc, char** argv){
    try{
        //checks for valid number of arguments
    if(argc != 2){
        throw runtime_error("Invalid Number of arguments");
    }

    //checks for valid file
    struct stat statbuff;
    if(stat(argv[1], &statbuff)){
        throw runtime_error("Please input a valid file");
    }
    
    //outputting file statistics
    cout << "Inode number:  " << statbuff.st_ino << endl;
    cout << "File type:  ";

    //Find out file type
    switch(statbuff.st_mode & S_IFMT){
        case S_IFDIR:
            cout << "directory file" << endl;
            break;
        case S_IFCHR:
            cout << "character-oriented file" << endl;
            break;
        case S_IFBLK:
            cout << "block-oriented file" << endl;
            break;
        case S_IFREG:
            cout << "regular file" << endl;
            break;
        case S_IFLNK:
            cout << "symbolic file" << endl;
            break;
        case S_IFSOCK:
            cout << "socket file" << endl;
            break;
        case S_IFIFO:
            cout << "FIFO or pipe file" << endl;
            break;
        default:
            cout << "Unknown file type" << endl;
            break;
    }        
    //More stats
    cout << "User Name: " << getpwuid(statbuff.st_uid) -> pw_name << endl;
    cout << "Total size: " << statbuff.st_size << endl;
    cout << "Date:  " << ctime(&statbuff.st_ctime) << endl;
    }
    catch (runtime_error &except){
        cerr << except.what() << endl;
    }
    return 0;
}