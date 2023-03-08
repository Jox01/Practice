public class Process : MonoBehaviour
{

    static private string[] productLines = System.IO.File.ReadAllLines(@".\products.txt");
    static private string[] buysLines = System.IO.File.ReadAllLines(@".\buys.txt");
    static private string[] clientsLines = System.IO.File.ReadAllLines(@".\clients.txt");

    public Process() { }

    private void getClients()
    {
        string name;
        string lastName;
        string postalCode;
        string phone;
        string dateRegister;
        int count = 0;

        foreach(string line : clientsLines){
            if (line.StartWith("name: "))
            {
                name = line.Replace("name: ", "");
            }
            if (line.StartWith("last_name: "))
            {
                lastName = lines.Replace("last_name: ", "");
            }
            if (line.StartWith("cp: "))
            {
                postalCode = line.Replace("cp: ", "");
            }
            if (line.StartWith(""))
        }
    }


}