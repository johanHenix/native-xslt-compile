<?xml version="1.0" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <testsuite errors="0">
            <xsl:attribute name="name">
                <xsl:value-of select="/some/path/@name"/>
            </xsl:attribute>
            <xsl:element name="testcase" />
        </testsuite>
    </xsl:template>
</xsl:stylesheet>
