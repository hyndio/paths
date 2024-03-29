# 关于本工程

## 重构目的

重构一下流程引擎部分。主要是针对上一个版本实际运行过程中缺陷、问题的思考、改进，
也当是对自己技术、思想的总结及改进，希望能找回自己的那份激情、斗志及快乐，重拾以前的那种生活、工作态度。

## 一些设想

1. 是否兼容前一版本？流程引擎部分要兼容。
2. 本工程的过程文档使用markdown格式。单独建立一个模块显示文档。
3. Bootstrap-2.2.1 + 其他基于它的js插件。
4. seajs-1.3.0 + less-1.3.0 + jquery-1.8.2 + 部署时编译、压缩
5. spring3 + spring3-mvc + hibernate4 + tomcat + mysql5
6. 使用javadoc生成文档。
7. 提供一个存储表单（或者说流程过程变量的值）的策略。可参考服务提供者模式（例子：jdbc）。
8. 文档存储，可以选择存储到文件系统或NoSQL。可参考服务提供者模式（例子：jdbc）。
9. 流程结束后，可分部门保存文档到自己部门所创建的目录中，可提供输入、保存用户自己确定的关键词，以便查找（数据会冗余）。
10. 操作日志记录要完善。
11. 时间任务，计划任务。
12. 使用路径名来表示更多意思。（?有点模糊）
13. 流程的控制与表单的字段关联。
14. 消息推送到工作空间。
15. 使用二级缓存（spring来管理）。

## 主要指导原则（来自《UNIX编程艺术》）

- K.I.S.S.
- 分离原则：策略同机制分离，接口同引擎分离。
	*策略和机制是按照不同的时间尺度变化的，策略的变化要远远快于机制。*
- 表示原则：把知识叠入数据以求逻辑质朴而健壮。
	*在设计中，你应该主动将代码的复杂度转移到数据之中去。*（所以说，数据的结构很重要！）
- 扩展原则：设计着眼未来，未来总比预想中来得快。
	*在设计的时候考虑宽容性，而不是用过分纵容的实现来补救标准的不足。*
- 补救原则：出现异常时，马上退出并给出足够的错误信息。
- 通俗原则：接口设计避免标新立异。


