<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.7.6/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.7.6/themes/icon.css">
    <script type="text/javascript" src="jquery-easyui-1.7.6/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.7.6/jquery.easyui.min.js"></script>
    <style>
        #head {
            position: relative;
        }

        #div1 {
            position: absolute;
            margin-top: -60px;
            margin-left: 1250px;
        }

        #div1 a {
            color: white;
            margin-left: 20px;
        }

        #div2 {
            position: absolute;
            margin-top: -15px;
            margin-left: 400px;
        }

        #div2 .time {
            width: 200px;
            margin-top: 0px;
            margin-left: 750px;
        }

        .icon-clock {
            background: url('jquery-easyui-1.7.6/themes/icons/clock.png') no-repeat 3px 2px;
        }

        .icon-bullet_go {
            background: url('jquery-easyui-1.7.6/themes/icons/bullet_go.png') no-repeat 3px 2px;
        }

        .icon-user {
            background: url('jquery-easyui-1.7.6/themes/icons/user.png') no-repeat 3px 2px;
        }

        .icon-group {
            background: url('jquery-easyui-1.7.6/themes/icons/group.png') no-repeat 3px 2px;
        }
        .none{
            display: none;
        }

        .text {
            color: #0c7cd5;
            border: 1px solid lightgrey;
            background-color: #F5F5F5;
            margin: 10px 0px 10px 10px;
            height: 40px;
            line-height: 40px;
            padding-left: 20px;
        }

        .tabl {
            padding-left: 10px;
        }

        #addusertext {
            color: #0c7cd5;
            border: 1px solid lightgrey;
            background-color: #F5F5F5;
            margin: 10px 0px 10px 10px;
            height: 170px;
            line-height: 50px;
            padding-left: 20px;
        }

        #addemptext {
            background-color: #F5F5F5;
            margin: 10px 10px;
            border: 1px solid lightgrey;
        }

        #addemptext .buttom {
            color: #0c7cd5;
            padding: 15px 15px;
        }
        select{
            width: 150px;
            height: 24px;
            line-height: 24px;
        }
        tr{
            height: 40px;
        }
        #addemptext>table td{
            border-bottom: 1px solid lightgrey;
        }
        .td2{
            padding-left: 20px;
        }
        #usermes {
            background-color: #F5F5F5;
            color: #0c7cd5;
            margin: 10px 10px;
            border: 1px solid lightgrey;
        }
        #usermes .user{
            padding-left: 20px;
            height: 40px;
            line-height: 40px;
        }
        select{
            width:150px;
            height: 30px;
        }
        .notics{
            font-size: 20px;
            margin-left: 30px;
            color: #4b72a4;
        }
        #selectnoticemes > div {
            float: left;
        }

        #selectnoticemes div img {
            width: 200px;
            margin: 0px 40px 0px 30px;
        }

        .noticdiv1 {
            width: 600px;
        }

        .noticdiv2 {
            text-align: center;
        }
    </style>
</head>
<body class="easyui-layout ">
<div data-options="region:'north' " style="height: 95px;background-image: url('img/123.jpg');padding-left: 20px;"
     id="head">
    <h1>人事管理系统</h1>
    <div id="div1">
        <a herf="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-computer'">网站首页</a>
        <a herf="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-no'">注销退出</a>
    </div>
    <div id="div2">
        <span class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-user'">当前用户【】</span>
        <span class="easyui-linkbutton time icon-clock" id="sj" data-options="plain:true,iconCls:'icon-clock'">2019年4月28  19:11:58</span>
    </div>
</div>
<div data-options="region:'west',split:true" style="width:210px;background-color:#E5F0FF">
    <div class="easyui-accordion" style="width:190px;margin-left:5px;">
        <div title="用户管理" data-options="iconCls:'icon-group'" style="overflow:auto;padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="selectuser">查询用户</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'"
               style="width: 100%;text-align: left" id="adduser">添加用户</a>
        </div>
        <div title="部门管理" data-options="iconCls:'icon-computer'" style="overflow:auto;padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="selectdepartment">查询部门</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'"
               style="width: 100%;text-align: left" id="adddepartment">添加部门</a>
        </div>
        <div title="职位管理" data-options="iconCls:'icon-computer'" style="overflow:auto;padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="selectpost">查询职位</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'"
               style="width: 100%;text-align: left" id="addpost">修改职位</a>
        </div>
        <div title="员工管理" data-options="iconCls:'icon-computer'" style="overflow:auto;padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="selectemp">查询员工</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'"
               style="width: 100%;text-align: left" id="addemp">添加员工</a>
        </div>
        <div title="公告管理" data-options="iconCls:'icon-computer'" style="overflow:auto;padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="selectnotice">查询公告</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="addnotice">添加公告</a>
        </div>
        <div title="下载中心" data-options="iconCls:'icon-computer'" style="padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="selectdoc">查询文档</a>
            <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'"
               style="width: 100%;text-align: left" id="adddoc">上传文档</a>
        </div>
    </div>
</div>
<div data-options="region:'center' ,split:true">
    <!--<div class="easyui-tabs" style="height:100%" id="usertab">-->
    <div style="background-color: #E5F0FF" class="centerhead">
        <span class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-bullet_go'" id="centerhead">
            当前位置：当前用户>用户状态
        </span>
    </div>
    <div id="selectusertext" class="none">
        <div class="text">
        登录名：<input type="text">
        用户名：<input type="text">
        用户状态：<input type="text">
        <input type="button" value="查询">
        <input type="button" value="删除">
    </div>
        <div class="tabl">
            <table id="dg" class="easyui-datagrid" style="width:1222px;height:260px"
           data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true" class="ck" style="width: 100px"></th>
            <th data-options="field:'itemid',width:230,align:'center'">登录名</th>
            <th data-options="field:'productid',width:200,align:'center'">密码</th>
            <th data-options="field:'listprice',width:230,align:'center'">用户名</th>
            <th data-options="field:'unitcost',width:100,align:'center'">状态</th>
            <th data-options="field:'attr1',width:300,align:'center'">创建时间</th>
            <th data-options="field:'status',width:100,align:'center'">操作</th>
        </tr>
        </thead>
        <tr>
            <td></td>
            <td>S0001</td>
            <td>扫地僧</td>
            <td>15919754435</td>
            <td>男</td>
            <td>广东</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
        <tr>
            <td></td>
            <td>S0002</td>
            <td>乔峰</td>
            <td>15919754435</td>
            <td>男</td>
            <td>广东</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
        <tr>
            <td></td>
            <td>S0003</td>
            <td>段誉</td>
            <td>15919754435</td>
            <td>男</td>
            <td>广东</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
        <tr>
            <td></td>
            <td>S0004</td>
            <td>王语嫣</td>
            <td>15919754435</td>
            <td>男</td>
            <td>广东</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
        <tr>
            <td></td>
            <td>S0004</td>
            <td>王语嫣</td>
            <td>15919754435</td>
            <td>男</td>
            <td>广东</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
        <tr>
            <td></td>
            <td>S0004</td>
            <td>王语嫣</td>
            <td>15919754435</td>
            <td>男</td>
            <td>广东</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
        <tr>
            <td></td>
            <td>S0004</td>
            <td>王语嫣</td>
            <td>15919754435</td>
            <td>男</td>
            <td>广东</td>
            <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
        </tr>
    </table>
        </div>
    </div>
    <div id="addusertext" class="none">
        姓名：<input type="text">
        状态：<input type="text"><br>
        登录名：<input type="text">
        密码：<input type="text"><br>
        <input type="submit" value="添加">
        <input type="button" value="取消">
    </div>
    <div id="selectemptext" class="none">
        <div class="text" style="height: 80px">
            职位：
            <select>
                <option selected>
                    --请选择职位--
                </option>
                <option>工程师</option>
                <option>会计师</option>
                <option>普通职员</option>
            </select>
            姓名：<input type="text">
            身份证号码：<input type="text"><br>
            性别：
            <select>
                <option selected>
                    --请选择性别--
                </option>
                <option>男</option>
                <option>女</option>
            </select>
            手机号：<input type="text">
            所属部门：
            <select>
                <option selected>
                    --请选择部门--
                </option>
                <option>财务部</option>
                <option>学术部</option>
                <option>公关部</option>
            </select>
            <input type="button" value="查询">
            <input type="button" value="删除">
        </div>
        <div class="tabl">
            <table id="dg2" class="easyui-datagrid" style="width:1310px;height:260px"
                   data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
                <thead>
                <tr>
                    <th data-options="field:'itemid',width:70,align:'center'">姓名</th>
                    <th data-options="field:'productid',width:60,align:'center'">性别</th>
                    <th data-options="field:'listprice',width:120,align:'center'">手机号码</th>
                    <th data-options="field:'unitcost',width:150,align:'center'">邮箱</th>
                    <th data-options="field:'attr1',width:100,align:'center'">职位</th>
                    <th data-options="field:'attr2',width:100,align:'center'">学历</th>
                    <th data-options="field:'attr3',width:150,align:'center'">身份证号码</th>
                    <th data-options="field:'attr4',width:100,align:'center'">部门</th>
                    <th data-options="field:'attr5',width:150,align:'center'">联系地址</th>
                    <th data-options="field:'attr6',width:176,align:'center'">建档日期</th>
                    <th data-options="field:'status',width:100,align:'center'">操作</th>
                </tr>
                </thead>
                <tr>
                    <td>小明</td>
                    <td>男</td>
                    <td>12345678910</td>
                    <td>123456@qq.com</td>
                    <td>工程师</td>
                    <td>本科</td>
                    <td>123456789012345</td>
                    <td>学术部</td>
                    <td>广东省广州市</td>
                    <td>2019-02-19 15:32:44</td>
                    <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
                </tr>
                <tr>
                    <td>旺财</td>
                    <td>男</td>
                    <td>12345678910</td>
                    <td>123456@qq.com</td>
                    <td>工程师</td>
                    <td>研究生</td>
                    <td>123456789012345</td>
                    <td>学术部</td>
                    <td>广东省深圳市</td>
                    <td>2019-02-04 15:32:44</td>
                    <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                </tr>
            </table>
        </div>
    </div>
    <div id="addemptext" class="none">
        <div class="buttom" style="border-bottom: 1px solid lightgrey;">
            <table>
                <tr>
                    <td><span class="sp1">姓名：</span></td><td><input type="text"></td>
                    <td class="td2"><span>身份证号码：</span></td><td><input type="text"></td>
                </tr>
                <tr>
                    <td>
                        <span class="sp1">性别：</span></td><td>
                        <input type="radio" name="sex">男<input type="radio" name="sex">女
                    </td>
                    <td>
                        <span class="sp2">职位：</span></td><td>
                        <select>
                            <option selected>
                                --请选择职位--
                            </option>
                            <option>工程师</option>
                            <option>会计师</option>
                            <option>普通职员</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><span class="sp1">学历：</span></td><td><input type="text"></td>
                    <td class="td2"><span class="sp2">邮箱：</span></td><td><input type="text"></td>
                </tr>
                <tr>
                    <td><span class="sp1">手机：</span></td><td><input type="text"></td>
                    <td class="td2"><span class="sp2">电话：</span></td><td><input type="text"></td>
                </tr>
            </table>
        </div>
        <table class="buttom" style="width: 100%">
            <tr>
                <td><span class="sp1">政治面貌：</span></td><td><input type="text" class="ip1"></td>
                <td class="td2"><span>QQ号码：</span></td><td style="width: 60%"><input type="text"></td>
            </tr>
            <tr>
                <td><span class="sp1">联系地址：</span></td><td><input type="text" class="ip1"></td>
                <td class="td2"><span>邮政编码：</span></td><td><input type="text"></td>
            </tr>
            <tr>
                <td><span class="sp1">出生日期：</span></td><td><input type="text" class="ip1"></td>
                <td class="td2"><span>民族：</span></td><td><input type="text"></td>
            </tr>
            <tr>
                <td><span class="sp1">所学专业：</span></td><td><input type="text" class="ip1"></td>
                <td class="td2"><span>爱好：</span></td><td><input type="text"></td>
            </tr>
            <tr>
                <td><span class="sp1">备注：</span></td><td><input type="text" class="ip1"></td>
                <td class="td2">
                    <span>所属部门：</span></td><td>
                    <select>
                        <option selected>
                            --部门选择--
                        </option>
                        <option>财务部</option>
                        <option>学术部</option>
                        <option>公关部</option>
                    </select>
                </td>
            </tr>
        </table>
        <div>
            <input type="submit" value="添加">
            <input type="button" value="取消">
        </div>
    </div>
    <div id="selectdept" class="tabl none">
        <table id="dg3" class="easyui-datagrid" style="width:1183px;height:260px"
               data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
            <thead>
            <tr>

                <th data-options="field:'itemid',width:350,align:'center'">部门名称</th>
                <th data-options="field:'productid',width:500,align:'center'">备注</th>
                <th data-options="field:'status',width:300,align:'center'">操作</th>
            </tr>
            </thead>
            <tr>
                <td>财务部</td>
                <td>无</td>
                <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
            </tr>
            <tr>
                <td>学术部</td>
                <td>无</td>
                <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
            </tr>
            <tr>
                <td>公关部</td>
                <td>无</td>
                <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
    <div id="adddept" class="text none" style="height: 120px">
        部门名称：<input type="text"><br>
        备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text"><br>
        <input type="submit" value="添加">&nbsp;
        <input type="button" value="取消">
    </div>
    <div id="selectjob" class="tabl none">
        <table id="dg4" class="easyui-datagrid" style="width:1183px;height:260px"
               data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">
            <thead>
            <tr>
                <th data-options="field:'itemid',width:350,align:'center'">职位名称</th>
                <th data-options="field:'productid',width:500,align:'center'">备注</th>
                <th data-options="field:'status',width:300,align:'center'">操作</th>
            </tr>
            </thead>
            <tr>
                <td>工程师</td>
                <td>无</td>
                <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
            </tr>
            <tr>
                <td>会计师</td>
                <td>无</td>
                <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
            </tr>
            <tr>
                <td>普通职员</td>
                <td>无</td>
                <td><a href="">修改</a>&nbsp;&nbsp;<a href="">删除</a></td>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td></td>
            </tr>
            <tr>
                <td></td>
            </tr>
        </table>
    </div>
    <div id="addjob" class="text none" style="height: 120px">
        职位名称：<input type="text"><br>
        备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text"><br>
        <input type="submit" value="添加">&nbsp;
        <input type="button" value="取消">
    </div>
    <div id="selectnoticemes" class="text none" style="width: 1200px;height: 650px">
        <h1 style="text-align: center">今日公告</h1>
        <div class="noticdiv1"><a href="" class="notics">五一放假日程安排</a><br>
            <a href="" class="notics">端午节假日安排</a><br>
            <a href="" class="notics">粤嵌杯开幕仪式安排</a><br>
            <a href="" class="notics">5月15日总公司领导莅临视察</a><br>
            <a href="" class="notics">关于提升公司绩效的一百种方法</a><br>
            <a href="" class="notics">策划书如何做</a><br>
            <a href="" class="notics">关于偷鸡摸狗者的一百种惩罚方法</a><br>
            <a href="" class="notics">5月15日总公司领导莅临视察</a><br>
            <a href="" class="notics">年终奖等级评定新规定</a><br>
            <a href="" class="notics">关于提升公司绩效的一百种方法</a><br>
            <a href="" class="notics">粤嵌杯闭幕仪式安排</a><br>
        </div>
        <div class="noticdiv2">
            <div><img src="img/x4.jpg"><br><a href="">4月30日习总莅临视察</a></div>
            <div><img src="img/x2.jpg"><br><a href="">5月3日CEO峰会</a></div>
            <div><img src="img/x3.jpg"><br><a href="">5月9日习总亲切慰问我司</a></div>
        </div>
    </div>
    <div id="usermes">
        <div class="user" style="border-bottom: 1px solid lightgrey;">
            <span>用户姓名：</span><span></span>
        </div>
        <div class="user" style="border-bottom: 1px solid lightgrey;">
            <span>用户状态：</span><span style="color: red">未审核</span>
        </div>
        <div class="user">
            <span>创建时间：</span><span></span>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function () {
       $("#selectuser").click(function () {
           addtab("#selectusertext","查询用户","用户管理");
       });
        $("#adduser").click(function () {
            addtab("#addusertext","添加用户","用户管理");
        });
        $("#addemp").click(function () {
            addtab("#addemptext","查询员工","员工管理");
        });
        $("#selectemp").click(function () {
            addtab("#selectemptext","查询员工","员工管理");
        });
        $("#selectdepartment").click(function () {
            addtab("#selectdept","查询部门","部门管理");
        });
        $("#adddepartment").click(function () {
            addtab("#adddept","添加部门","部门管理");
        });
        $("#selectpost").click(function () {
            addtab("#selectjob","查询职位","职位管理");
        });
        $("#addpost").click(function () {
            addtab("#addjob","添加职位","职位管理");
        });
        $("#selectnotice").click(function () {
            addtab("#selectnoticemes","查看公告","公告管理");
        });
        setInterval("sj.innerHTML=new Date().toLocaleString()", 1000);
    });
    var a=new Array();
    a[0]="#selectusertext";
    a[1]="#addusertext";
    a[2]="#addemptext";
    a[3]="#usermes";
    a[4]="#selectdept";
    a[5]="#adddept";
    a[6]="#selectjob";
    a[7]="#addjob";
    a[8]="#selectnoticemes";
    a[9]="#selectemptext";
    function addtab(id,name,title) {
        for(var i=0;i<a.length;i++){
            if(a[i]==id){
                $(a[i]).css("display","block");
                $('#dg').datagrid("resize");
                $('#dg2').datagrid("resize");
                $('#dg3').datagrid("resize");
                $('#dg4').datagrid("resize");
            }else {
                $(a[i]).css("display","none");
            }
        }
        $("#centerhead .l-btn-text").html("当前位置："+title+">"+name);
    };
</script>