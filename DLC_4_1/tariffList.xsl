<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"><xsl:template match="/">
    <html>
        <body>
            <h2>My Tariff List</h2>
            <table border="1">
                <tr bgcolor="#9acd32">
                    <th>Name</th>
                    <th>Species</th>
                    <th>Subscription fee</th>
                    <th>cost in NW</th>
                    <th>cost in other NW</th>
                    <th>cost sms</th>
                    <th>cost Internet</th>
                </tr>
                <xsl:for-each select="tariffList/tariff">
                <tr>
                    <td><xsl:value-of select="name"/></td>
                    <td><xsl:value-of select="species"/></td>
                    <td><xsl:value-of select="subscriptionFee"/></td>
                    <td><xsl:value-of select="costMinuteInNW"/></td>
                    <td><xsl:value-of select="costMinuteInOtherNW"/></td>
                    <td><xsl:value-of select="costSms"/></td>
                    <td><xsl:value-of select="costInternet"/></td>
                </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template></xsl:stylesheet>