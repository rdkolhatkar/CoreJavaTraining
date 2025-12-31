package com.practice;

import java.net.MalformedURLException;
import java.net.URL;

public class URLCompare {
/*
     What will be the output when you compare site URL with its ip address?
     For example if we have one Url called "abc.com" and it's ip address is "89.90.98.101"
     Then if we compare "abc.com == 89.90.98.101" Or "(abc.com).equals(89.90.98.101)" then will it return true or false
*/
/*
    ===============================================================================
    README: HOW TO FIND THE IP ADDRESS OF ANY WEBSITE
    ===============================================================================

    This document explains MULTIPLE ways to find the IP address of any website
    such as:
    - Google      (www.google.com)
    - Amazon      (www.amazon.in)
    - Flipkart    (www.flipkart.com)
    - JustDial    (www.justdial.com)

    The steps are explained separately for:
    - Windows
    - Linux
    - macOS

    This guide is written for FRESHERS with easy-to-understand comments.

    ===============================================================================
    BASIC CONCEPT (IMPORTANT FOR INTERVIEWS)
    ===============================================================================

    A website name like:
        www.google.com
        www.amazon.in

    is called a DOMAIN NAME.

    Computers do NOT understand domain names.
    They communicate using IP addresses like:
        142.250.183.36

    DNS (Domain Name System) converts:
        Domain Name  --->  IP Address

    ===============================================================================
    METHOD 1: USING "ping" COMMAND
    ===============================================================================

    This is the simplest method to check the IP address of a website.

    -------------------------------------------------------------------------------
    WINDOWS (Command Prompt / Git Bash)
    -------------------------------------------------------------------------------

    Step 1) Open Command Prompt
            - Press Windows + R
            - Type cmd
            - Press Enter

            OR

            Open Git Bash (if installed)

    Step 2) Run the ping command

        ping www.google.com

    Example Output:
        Pinging www.google.com [142.250.183.36] with 32 bytes of data:

    Here:
        142.250.183.36  ---> IP address of Google

    Try other websites:

        ping www.amazon.in
        ping www.flipkart.com
        ping www.justdial.com

    NOTE:
    - Some websites block ping requests
    - Even then, the IP may still be shown

    -------------------------------------------------------------------------------
    LINUX
    -------------------------------------------------------------------------------

    Step 1) Open Terminal
            - Shortcut: Ctrl + Alt + T

    Step 2) Run the command

        ping -c 4 www.google.com

    Explanation:
    - "-c 4" means send only 4 packets
    - IP address appears in the first line

    -------------------------------------------------------------------------------
    macOS
    -------------------------------------------------------------------------------

    Step 1) Open Terminal
            - Press Cmd + Space
            - Type Terminal
            - Press Enter

    Step 2) Run the command

        ping www.google.com

    ===============================================================================
    METHOD 2: USING "nslookup" (BEST FOR INTERVIEWS)
    ===============================================================================

    This is the MOST RECOMMENDED method for freshers and interviews.

    -------------------------------------------------------------------------------
    WINDOWS / LINUX / macOS
    -------------------------------------------------------------------------------

    Step 1) Open Terminal / Command Prompt / Git Bash

    Step 2) Run the command

        nslookup www.google.com

    Example Output:
        Name:    www.google.com
        Address: 142.250.183.36

    Here:
        Address = IP address of the website

    Try other examples:

        nslookup www.amazon.in
        nslookup www.flipkart.com
        nslookup www.justdial.com

    INTERVIEW TIP:
    - nslookup works even when ping is blocked
    - Always mention this command in interviews

    ===============================================================================
    METHOD 3: USING "tracert" / "traceroute"
    ===============================================================================

    This command shows the network path and destination IP.

    -------------------------------------------------------------------------------
    WINDOWS
    -------------------------------------------------------------------------------

    Step 1) Open Command Prompt

    Step 2) Run the command

        tracert www.google.com

    Explanation:
    - Last IP address in the output is usually the destination server IP

    -------------------------------------------------------------------------------
    LINUX / macOS
    -------------------------------------------------------------------------------

    Step 1) Open Terminal

    Step 2) Run the command

        traceroute www.google.com

    ===============================================================================
    METHOD 4: USING "dig" COMMAND (Advanced)
    ===============================================================================

    Mostly used by Linux and macOS users.

    -------------------------------------------------------------------------------
    LINUX / macOS
    -------------------------------------------------------------------------------

    Step 1) Open Terminal

    Step 2) Run the command

        dig www.google.com

    Look for the "ANSWER SECTION":

        ANSWER SECTION:
        www.google.com.  300  IN  A  142.250.183.36

    Explanation:
    - "A" record represents IPv4 address
    - The number shown is the IP address

    ===============================================================================
    METHOD 5: USING ONLINE / EXTERNAL WEBSITES
    ===============================================================================

    No command line knowledge required.

    -------------------------------------------------------------------------------
    1) DNS CHECKER
    -------------------------------------------------------------------------------

    Website:
        https://dnschecker.org

    Steps:
        Step 1) Open dnschecker.org
        Step 2) Enter domain name (example: www.google.com)
        Step 3) Select "A" record
        Step 4) Click Search
        Step 5) IP address will be displayed

    -------------------------------------------------------------------------------
    2) WHAT IS MY IP ADDRESS
    -------------------------------------------------------------------------------

    Website:
        https://www.whatismyipaddress.com

    Steps:
        Step 1) Open the website
        Step 2) Search for "Website IP Lookup"
        Step 3) Enter the domain name
        Step 4) View the IP address

    -------------------------------------------------------------------------------
    3) MX TOOLBOX
    -------------------------------------------------------------------------------

    Website:
        https://mxtoolbox.com

    Steps:
        Step 1) Enter website name
        Step 2) Select "A Lookup"
        Step 3) Click Lookup
        Step 4) IP address will be shown

    ===============================================================================
    IMPORTANT INTERVIEW NOTE (MUST REMEMBER)
    ===============================================================================

    A single website can have MULTIPLE IP addresses.

    Reasons:
    - Load Balancing
    - CDN (Cloudflare, Akamai, etc.)
    - Different geographic locations
    - High traffic handling

    Example:
    - www.google.com may return different IPs for different users

    ===============================================================================
    ONE-LINE INTERVIEW ANSWER
    ===============================================================================

    We can find the IP address of any website using commands like ping, nslookup,
    tracert, dig, or by using online DNS lookup tools. DNS converts domain names
    into IP addresses.

    ===============================================================================
    END OF README
    ===============================================================================
*/
/*
    ===============================================================================
    README: HOW TO FIND WHICH WEBSITE BELONGS TO AN IP ADDRESS
    ===============================================================================

    Problem Statement:
    ------------------
    Let’s say we already have an IP address and we want to know:
    "Which website or organization does this IP address belong to?"

    Example IP Address:
    -------------------
        142.250.183.36

    ===============================================================================
    IMPORTANT CONCEPT (VERY IMPORTANT FOR INTERVIEWS)
    ===============================================================================

    An IP address does NOT always belong to a single website.

    Reasons:
    --------
    1) Shared hosting
    2) Load balancers
    3) CDN (Cloudflare, Akamai, Google CDN, etc.)
    4) Virtual hosting

    Because of this:
    ---------------
    - One IP address can host MULTIPLE websites
    - Sometimes we can only find the OWNER (company), not exact website

    ===============================================================================
    METHOD 1: USING REVERSE DNS LOOKUP (nslookup)
    ===============================================================================

    This is the MOST COMMON and INTERVIEW-FRIENDLY method.

    -------------------------------------------------------------------------------
    WINDOWS / LINUX / macOS
    -------------------------------------------------------------------------------

    Step 1) Open Command Prompt / Terminal / Git Bash

    Step 2) Run the command:

        nslookup 142.250.183.36

    Example Output:
    ---------------
        Name:    bom07s27-in-f4.1e100.net
        Address: 142.250.183.36

    Explanation:
    ------------
    - "1e100.net" is a domain owned by Google
    - This IP belongs to Google's infrastructure

    NOTE:
    -----
    - If reverse DNS is not configured, it may show:
      "Non-existent domain"

    ===============================================================================
    METHOD 2: USING ping -a (WINDOWS ONLY)
    ===============================================================================

    This method resolves IP address to hostname.

    -------------------------------------------------------------------------------
    WINDOWS
    -------------------------------------------------------------------------------

    Step 1) Open Command Prompt

    Step 2) Run the command:

        ping -a 142.250.183.36

    Example Output:
    ---------------
        Pinging bom07s27-in-f4.1e100.net [142.250.183.36]

    Explanation:
    ------------
    - "-a" flag converts IP address to host name
    - Works only if reverse DNS exists

    ===============================================================================
    METHOD 3: USING host COMMAND (LINUX / macOS)
    ===============================================================================

    -------------------------------------------------------------------------------
    LINUX / macOS
    -------------------------------------------------------------------------------

    Step 1) Open Terminal

    Step 2) Run the command:

        host 142.250.183.36

    Example Output:
    ---------------
        36.183.250.142.in-addr.arpa domain name pointer bom07s27-in-f4.1e100.net.

    Explanation:
    ------------
    - Shows reverse DNS record
    - Helps identify hosting organization

    ===============================================================================
    METHOD 4: USING ONLINE REVERSE IP LOOKUP WEBSITES
    ===============================================================================

    These websites are VERY USEFUL when command-line tools do not give clear results.

    -------------------------------------------------------------------------------
    1) VIEWDNS - REVERSE IP LOOKUP
    -------------------------------------------------------------------------------

    Website:
    --------
        https://viewdns.info/reverseip/

    Steps:
    ------
    1) Open the website
    2) Enter the IP address (example: 142.250.183.36)
    3) Click "Search"
    4) List of domains hosted on that IP is displayed

    NOTE:
    -----
    - This method can show MULTIPLE websites on same IP

    -------------------------------------------------------------------------------
    2) WHOIS LOOKUP
    -------------------------------------------------------------------------------

    Website:
    --------
        https://who.is
        https://ipinfo.io

    Steps:
    ------
    1) Enter the IP address
    2) View details like:
       - Organization name
       - ISP
       - Country
       - ASN number

    Explanation:
    ------------
    - Whois usually shows the OWNER of the IP
    - Not always the exact website name

    ===============================================================================
    METHOD 5: USING SSL CERTIFICATE (ADVANCED METHOD)
    ===============================================================================

    This works only if the IP supports HTTPS (port 443).

    -------------------------------------------------------------------------------
    LINUX / macOS / WINDOWS (with OpenSSL)
    -------------------------------------------------------------------------------

    Step 1) Run the command:

        openssl s_client -connect 142.250.183.36:443

    Explanation:
    ------------
    - SSL certificate may contain:
      - Domain names
      - Organization name
      - Issuer details

    ===============================================================================
    WHY YOU MAY NOT FIND A WEBSITE NAME
    ===============================================================================

    Common Reasons:
    ---------------
    1) IP belongs to CDN
    2) Reverse DNS is not configured
    3) IP hosts many websites
    4) Load balancer IP

    Example:
    --------
    - Google, Amazon, Flipkart use CDNs
    - Real website IPs are often hidden

    ===============================================================================
    INTERVIEW ONE-LINE ANSWER
    ===============================================================================

    If we have an IP address, we can find which website or organization it belongs
    to using reverse DNS lookup (nslookup), ping -a, host command, reverse IP lookup
    websites, or Whois lookup. However, one IP address can host multiple websites.

    ===============================================================================
    END OF README
    ===============================================================================
*/
    public static void main(String[] args) {
        try {
            System.out.println(new URL("https://app.hubspot.com").equals(new URL("https://104.17.92.187")));
            // Result of this above comparison between "https://app.hubspot.com" & "https://104.17.92.187" is 'true'
            System.out.println(new URL("https://www.google.com").equals(new URL("https://142.251.222.100")));
            // Result of this above comparison between "https://www.google.com" & "https://142.251.222.100" is 'true'
            System.out.println(new URL("https://www.amazon.in").equals(new URL("https://18.239.144.69")));
            // Result of this above comparison between "https://www.amazon.in" & "https://18.239.144.69" is 'true'
            /*
                Important Note: Host ip addresses of public websites like google and Amazon might change frequently
                Use the command mentioned in above comments for verifying the Ip address through command prompt/terminal/GitBash etc.
            */
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
