
//PROJECT IN C++ FOR BOOK MANAGEMENT SYSTEM BY USING THE FILE HANDLING CONCEPT.

#include<bits/stdc++.h>
using namespace std;

class Book
{
    int id;
    char name[20];
    float price;
public:
    Book(){
        id=0;
        strcpy(name,"no title");        //Constructor
        price=0;
    }

    void setdata();
    void showdata();
    // These are below file Handling functions
    int storedata();
    void viewalldata();
    void searchdata(char*);
    void deletedata(char*);
    void updatedata(char*);

};

void Book::setdata()
{
    cout<<"Enter the Book_ID , Book_Title , and BOOK_Price "<<endl;
    cin>>id;
    cin.ignore();
    cin.getline(name,19);
    cin>>price;
}

void Book::showdata()
{
    cout<<"BOOK_ID : "<<id<<endl<<"BOOK_TITLE : "<<name<<endl<<"BOOK_Price : "<<price<<endl;
}

int Book::storedata()
{
    if(id==0 && price==0){
        cout<<"\nData not Initialize "<<endl;
        return(-1);
    }
    else{

        ofstream fout;
        fout.open("My Book.txt",ios::app);      //open in append mode
        fout.write((char*)this,sizeof(*this));
        fout.close();
    }
}

void Book::viewalldata()
{
    ifstream fin;
    fin.open("My Book.txt",ios::in);
    if(!fin){
        cout<<"\nFile Not Found ";
    }
    else{
        fin.read((char*)this,sizeof(*this));        //Read data from File
        while(!fin.eof()){

            showdata();
            cout<<endl;
            fin.read((char*)this,sizeof(*this));

        }
    }
}

void Book::searchdata(char *t)
{

    int count_n=0;
    ifstream fin;
    fin.open("My Book.txt",ios::in);
    if(!fin)
        cout<<"\nFile Not Found "<<endl;
    else{

        fin.read((char*)this,sizeof(*this));
        while(!fin.eof()){

            if(!strcmp(t,this->name)){

                showdata();
                ++count_n;
            }
            fin.read((char*)this,sizeof(*this));
        }
        if(count_n==0)
            cout<<"\nData not Found "<<endl;
        fin.close();
    }
}

void Book::deletedata(char *t)
{
    ifstream fin;
    ofstream fout;
    fin.open("My Book.txt",ios::in);
    if(!fin){
        cout<<"\nFile Not Exist "<<endl;
    }
    else{

        fout.open("Temp.txt",ios::out);
        fin.read((char*)this,sizeof(*this));
        while(!fin.eof()){

            if(strcmp(name,t))
                fout.write((char*)this,sizeof(*this));

            fin.read((char*)this,sizeof(*this));
        }
        fin.close();
        fout.close();
        remove("My Book.txt");
        rename("Temp.txt","My Book.txt");
    }
}

void Book::updatedata(char *t)
{
    fstream file;
    file.open("My Book.txt",ios::in|ios::out|ios::ate);
    file.seekg(0);
    file.read((char*)this,sizeof(*this));
    while(!file.eof()){

        if(!strcmp(t,name)){

            setdata();
            file.seekp(file.tellp()-sizeof(*this));
            file.write((char*)this,sizeof(*this));
        }
        file.read((char*)this,sizeof(*this));
    }
    file.close();
}

int menu()
{
    int choice;
    cout<<"\t\t...........................";
    cout<<"\n\t\tBOOK MANAGEMENT SYSTEM"<<endl;
    cout<<"\t\t..........................."<<endl;
    cout<<"\n*****************************"<<endl;
    cout<<"\n\t 1. Insert Data"<<endl;
    cout<<"\n\t 2. Viewall Data "<<endl;
    cout<<"\n\t 3. Search Data "<<endl;
    cout<<"\n\t 4. Delete Data "<<endl;
    cout<<"\n\t 5. Update Data"<<endl;
    cout<<"\n\t 6. Exit"<<endl;
    cout<<"\n\nENTER YOUR CHOICE : ";
    cout<<"\n****************************\n";
    cin>>choice;
    return(choice);
}

int main()
{
    Book b1;
    char name[20];
    while(1){

        system("cls");  //For Clear Screen
        switch(menu())
        {
        case 1:
            b1.setdata();
            b1.storedata();
            cout<<"Store Data Succesfully..."<<endl;
            break;
        case 2:
            b1.viewalldata();   break;
        case 3:
            cout<<"Enter the Title for Search data "<<endl;
            cin.ignore();
            cin.getline(name,19);
            b1.searchdata(name);
            break;
        case 4:
            cout<<"Enter the Title for Delete data "<<endl;
            cin.ignore();
            cin.getline(name,19);
            b1.deletedata(name);
            break;
        case 5:
            cout<<"Enter the Title for Update data "<<endl;
            cin.ignore();
            cin.getline(name,19);
            b1.updatedata(name);
            break;
        case 6:
            system("cls");
            exit(0);    break;
        default:
            cout<<"\WRONG CHOICE "<<endl;   break;
        }
        system("pause");    //For end of main
    }

}



