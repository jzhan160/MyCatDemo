# MyCatDemo
configuration for my cat:
1. command line: /bin:
(1)install: mycat install
(2)start : mycat start
(3)stop: mycat stop
(4)status: mycat status
2. /conf:
(1)server.xml: define user
	<user name="root">
		<property name="password">123456</property>
		<property name="schemas">chatrobot</property>
	</user>
(2)schema.xml: 
<!-- 
 the schema is the db name which expose to java client.
 It maps to 2 dbs in mysql: db01 and db02.
-->
	<schema name="chatrobot" checkSQLschema="false" sqlMaxLimit="100">
 		<table name="user" dataNode="dn1,dn2" rule="rule1" />
	</schema>
	 
	<dataNode name="dn1" dataHost="localhost1" database="db01" />
	<dataNode name="dn2" dataHost="localhost1" database="db02" />
	 
	<dataHost name="localhost1" maxCon="1000" minCon="10" balance="0"
		writeType="0" dbType="mysql" dbDriver="native" switchType="1"  slaveThreshold="100">
		<heartbeat>select user()</heartbeat>
		<!-- can have multi write hosts -->
		<writeHost host="hostM1" url="localhost:3306" user="root"
			password="123456">
			<!-- can have multi read hosts -->
			<!--<readHost host="hostS2" url="192.168.1.200:3306" user="root" password="xxx" />-->
		</writeHost>
 
	</dataHost>
(3)rules.xml : defines rules of seperating dbs
  e.g.  id%(#node)
  <tableRule name="rule1">
		<rule>
			<columns>id</columns>
			<algorithm>mod-long</algorithm>
		</rule>
	</tableRule>
  <function name="mod-long" class="org.opencloudb.route.function.PartitionByMod">
		<!-- how many data nodes -->
		<property name="count">2</property>
	</function>
 3./logs
  see logs of mycat 
