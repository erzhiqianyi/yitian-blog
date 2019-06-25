## spring-boot-vue-blog
a blog based on spring boot and vue 
- [reference](#reference )
- [Project Init](#project-init)
	- [Vue Init](#vue-init)
	- [SpringBoot Init](#springboot-init)
- [Login](#login)
	- [login page](#login-page)
		- [vue page structure](#vue-page-structure)
		- [used components](#used-components)
			- [simple-line-icons](#simple-line-icons)
			- [BootstrapVue](#BootstrapVue)
			- [i18n](#i18n)
			- [use login page](#use-login-page)
			- [login page detail](#login-page-detail)
	- [login interface](#login-interface)
      - [use swagger](#use-swagger)
## reference 
- [spring-boot](https://spring.io/projects/spring-boot)
- [vue](https://cn.vuejs.org/index.html)
- [BootstrapVue](https://bootstrap-vue.js.org/docs/)
- [vue cli ](https://cli.vuejs.org/)
- [core-ui](https://github.com/coreui/coreui-vue)
## Project Init
project init ,include vue and spring-boot
### Vue Init 
1. create a vue project 
use vue cli3 create a vue project 
```
vue create blog
```
2. install 
```
npm install
```

3. Compiles and hot-reloads for development
```
npm run serve
```
project preview 
![hello vue](https://raw.githubusercontent.com/erzhiqianyi/spring-boot-vue-blog/master/image/hello.PNG)

4. Compiles and minifies for production
```
npm run build
```

5. Run  tests
```
npm run test
```

5. Lints and fixes files
```
npm run lint
```

7. Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

8.  defult project structure
```
blog
├─ node_modules 安装的依赖包
├─ public 存放静态资源，该目录下的静态资源会被复制到输出目录中（默认输出目录为dist）,不经过 webpack。需要通过绝对路径来引用它们。
│  ├─ favicon.ico 浏览器首段图标 
│  └─ index.html index 文件
├─ src 代码
│  ├─ assets 静态资源，如图片、图标、字体等
│       └─ logo.png
│  ├─ components  公共组件
│       └─ HelloWorld.vue
│  ├─ App.vue 路由组件的顶层路由
│  ├─ main.js vue入口文件
├─ babel.config.js  babel配置
├─ package-lock.json 锁定安装时的包的版本号,保证依赖一致
├─ package.json 定义项目所需要的各种模块，以及项目的配置信息，npm install下载所需的模块
```
9. 引入bootstrap vue 
```
vue add bootstrap-vue
```
会新建一个pugins目录
```
blog
├─ plugins
│       └─ bootstrap-vue.js
```

bootstrap-vue.js
```js
import Vue from 'vue'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue)

```

main.js中自动引入插件
```js
import './plugins/bootstrap-vue'
```
### SpringBoot Init
在[https://start.spring.io/](https://start.spring.io/)新建一个spring boot项目，使用maven管理项目。添加lombok和Spring Reatvice Web依赖，其他依赖用到再添加。

pom 文件如下
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.6.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.erzhiqianyi</groupId>
	<artifactId>spring-boot-blog</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>sprint boot blog</name>
	<description>a blog based on spring boot  </description>

	<properties>
		<java.version>10</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-webflux</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>io.projectreactor</groupId>
			<artifactId>reactor-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```
项目结构如下
```
spring-boot-blog
├─ src 源代码目录
│  ├─ main 
│       ├─ java java代码目录
│       ├─ resources 资源文件
│           ├─  application.properties默认配置文件
│  ├─ test  测试目录
│       ├─ java 测试java代码目录
├─ pom.xml project object model，项目对象模型

```
在idea中打开项目，运行BlogApplication的main函数，执行该方法，即可运行项目。

## Login 
login page and interface。
目前还没有设计数据结构和数据库，不做实际的登录功能，只写下页面效果和定义登录接口。
### login page 
在src目录下新建一个目录"views"，用来存放所有的路由组件,再新建一个pages来存放单独（没有其他页面结构）的路由组件，
```
blog
├─ src 代码
│  ├─ views 所有路由组件
│       └─ pages
│            └─ login
│                 └─ index.vue 登录路由

```
#### vue page structure 
```js
<template>
//组件 一个tempalte只能有一个根div组件
</template>

<script>
//脚本
</script>

<style scoped>
//样式
</style>
```
#### used components
##### simple-line-icons
Simple line icons with CSS, SAAS, LESS & Web-fonts files. 

把依赖加到package.json的dependencies中，depencies为生产环境需要的依赖，devDependencies为开发环境需要的依赖，开发环境需要构建工具，生产环境不需要。

这个依赖主要是一些icon,指定元素class即可使用相应的icon。
如
```html
<i class="icon-user"></i>
```
元素效果如下
![hello vue](https://github.com/erzhiqianyi/spring-boot-vue-blog/blob/master/image/simple-line-pre.PNG?raw=true)

在App.vue的style标签中引入```simple-line-icons```
```js
<style  lang="scss">
$simple-line-font-path: '~simple-line-icons/fonts/';
@import '~simple-line-icons/scss/simple-line-icons.scss';
</style>
```
##### BootstrapVue 
- [Layout and grid system](https://bootstrap-vue.js.org/docs/components/layout/#rows-b-row-and-b-form-row)
	- b-container
	- b-row
	- b-form-row
	- b-col
- [Cards](https://bootstrap-vue.js.org/docs/components/card/#comp-ref-b-card)
	- b-card
	- b-bard-body

#### i18n
使用[vue-i18n](https://github.com/kazupon/vue-i18n)实现国际化。我觉得即使不需要国际化，也可以引入，提取所有汉字，避免写死。
##### install 
在package.json中添加[vue-i18n](https://www.npmjs.com/package/vue-i18n)和[js-cookie](https://www.npmjs.com/package/js-cookie)。执行
```
npm install
```
##### register i18n
在src目录下新建目录"lang"，用来存放语言文件。
```
blog
├─ src 代码
│  ├─ lang 语言包
│      └─ index.js 
│      └─ en.js 英语语言包
│      └─ zh.js 中文语言包
```
如果需要其他语言，添加相应的文件，并在index.js注册。
index.js代码
```js
import Vue from 'vue'
import VueI18n from 'vue-i18n'

// 引入自定义语言文件
import enLocale from './en'
import zhLocale from './zh'
import Cookies from 'js-cookie'

Vue.use(VueI18n)

//定义message
const messages = {
  en: {
    ...enLocale,
  },
  zh: {
    ...zhLocale,
  },
}

const i18n = new VueI18n({
  // set locale
  // options: en | zh | es
  locale: getLanguage(),
  // set locale messages
  messages
})

// get lang from cookie, default return zh
export function getLanguage() {
  const chooseLanguage = Cookies.get('language')
  if (chooseLanguage) return chooseLanguage

  return 'zh'
}

export default i18n
```

在main.js中注册lang
```js
import i18n from './lang' // internationalization

new Vue({
  i18n ,
  render: h => h(App),
}).$mount('#app')
```
##### user i18n
使用$t('VALUE')来提取相应语言,在html中要用{{}}将值包装起来。
```js
// html 需要使用 {{}} 将 name包装起来
{{$t('name')}}

// js
$t('name')
```

#### use login page
在App.vue中引入Login.vue ,并注册,把Login.vue当作组件使用。
App.vue代码
```js
<template>
  <div id="app">
    <Login/>
  </div>
</template>

<script>
import Login from './views/pages/login'

export default {
  name: 'app',
  components: {
    Login
  }
}
</script>

<style  lang="scss">
$simple-line-font-path: '~simple-line-icons/fonts/';
@import '~simple-line-icons/scss/simple-line-icons.scss';

@import 'assets/scss/style';
</style>
```
main.js 代码
```js
import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import i18n from './lang' // internationalization

new Vue({
  i18n ,
  render: h => h(App),
}).$mount('#app')


```
运行项目
![Login page ](https://github.com/erzhiqianyi/spring-boot-vue-blog/blob/master/image/login_pre.png?raw=true)

#### login page detail
##### data bind
>当一个 Vue 实例被创建时，它将 data 对象中的所有的属性加入到 Vue 的响应式系统中。当这些属性的值发生改变时，视图将会产生“响应”，即匹配更新为新的值。

账号输入框和密码输入框需要相应的属性,在index.vue中，定义登录需要的数据。
```js
export default {
  name: "Login",
  data() {
    return {
      username: "",
      password: ""
    };
  },
};

```

输入框绑定相应数据。用v-model指令绑定data中的属性。
```js
<b-form-input
  type="text"
  class="form-control"
  :placeholder="$t('login.username')"
  autocomplete="username email"
  v-model.trim="username" //绑定username属性
/>
 
<b-form-input
  type="password"
  class="form-control"
  :placeholder="$t('login.password')"
  autocomplete="current-password"
  v-model.trim="password" //绑定password属性
/>
```

##### Event Handling
使用@cloick监听点击事件，在script中定义login方法
```js
<b-button variant="primary" class="px-4" @click="login">{{$t('login.login')}}</b-button>
```
```js
<script>
export default {
  name: "Login",
  methods: {
    login: function() {
		console.log("login method")
    }
  }
};
</script>
```
##### Computed Properties and Watchers
账号和密码需要校验长度和强度，可以通过[侦听属性](https://cn.vuejs.org/v2/guide/computed.html)来监控输入数据。这里使用[bootstrap-vue的Validation state feedback](https://bootstrap-vue.js.org/docs/components/form-group/)校验数据。
```js
  <b-form-group
    id="usernameLabel"
    label-for="username"
    :invalid-feedback="usernameInvalidFeedback"
    :state="usernameState"
  >
    <b-input-group class="mb-3">
      <b-input-group-prepend>
        <b-input-group-text>
          <i class="icon-user"></i>
        </b-input-group-text>
      </b-input-group-prepend>
      <b-form-input
        id="username"
        type="text"
        class="form-control"
        :placeholder="$t('login.username')"
        :state="usernameState"
        autocomplete="username email"
        v-model.trim="username"
      />
    </b-input-group>
  </b-form-group>
  <b-form-group
    id="passwordLabel"
    label-for="username"
    :invalid-feedback="passwordInvalidFeedback"
    :state="passwordState"
  >
	<b-input-group class="mb-4">
		<b-input-group-prepend>
		<b-input-group-text>
		   <i class="icon-lock"></i>
		</b-input-group-text>
		</b-input-group-prepend>
		    <b-form-input
		        id="password"
		        type="password"
		        class="form-control"
		        :placeholder="$t('login.password')"
		        :state="passwordState"
		        autocomplete="current-password"
		        v-model.trim="password"
		        />
	</b-input-group>
</b-form-group>
```
在computed中计算状态
```js
<script>
import { validSize } from "@/utils/validate";
export default {
  name: "Login",
  computed: {
    usernameState() {
      return (
        validSize(this.username, 3, 20, this.$t("login.username")).length === 0
      );
    },
    usernameInvalidFeedback() {
      return validSize(this.username, 3, 20, this.$t("login.username"));
    },
    passwordState() {
      return (
        validSize(this.password, 6, 30, this.$t("login.password")).length === 0
      );
    },
    passwordInvalidFeedback() {
      return validSize(this.password, 6, 30, this.$t("login.password"));
    }
  },
};
</script>
```

##### send http reqest
使用[axios](https://github.com/axios/axios/projects)发送http请求,在package.json中添加axios依赖。
axios发送post请求
```js
    axios
        .post(api, param)
        .then(response => {
			console.log("success")
       	})
        .catch(error => {
          console.log("fail");
        });
```
### login interface

#### use swagger
使用[swagger](https://swagger.io/)来生成Restful风格的Api文档。
- 添加swagger依赖
本项目使用WebFlux，没有Spring Mvc，目前只有swagger3.0支持WebFlux。在pom文件中添加如下依赖。springfox-swagger-ui提供页面来访问接口和测试接口。无需自己编写页面。
``` xml
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>3.0.0-SNAPSHOT</version>
</dependency
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-spring-webflux</artifactId>
	<version>3.0.0-SNAPSHOT</version>
</dependency
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>3.0.0-SNAPSHOT</version>
</dependency
```
- 配置swagger 
新建一个```swagger```包，存放swagger相关配置。
新建Swagger配置类```SwaggerConfig.java```
```java

@Configuration//标记为配置文件
@EnableSwagger2WebFlux //开启Swagger ,项目使用WebFlux,所以要使用WebFlux相关的注解
public class SwaggerConfig {

    //配置写在配置文件中，使用@Value注入
    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.termsOfServiceUrl}")
    private String termsOfServiceUrl;

    @Value("${swagger.author}")
    private String author;

    @Value("${swagger.url}")
    private String url;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.email}")
    private String email;


    @Value("${swagger.basePackage}")
    private String controllerPackage;

    //配置Swagger属性
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerApiInfo())//指定Api配置信息
                .select()
                .apis(RequestHandlerSelectors.basePackage(controllerPackage))//指定路由类所在包
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo swaggerApiInfo() {
        return new ApiInfoBuilder().title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(new Contact(author, url, email))
                .version(version)
                .build();
    }
}
```
- 添加接口
1. ```AuthController.java```

```java
@RestController
@RequestMapping("/api/auth")
@Log4j2
@Api(tags =SwaggerConstant.TAG_LOGIN)
public class AuthLoginController {

    @PostMapping("login/password")
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_PASSWORD,
            consumes = SwaggerConstant.MEDIA_JSON,
            produces = SwaggerConstant.MEDIA_JSON,
            response = User.class
    )
    public Mono<User> loginByPassWord(String username, String password) {
        return Mono.just(new User());
    }

    @PostMapping("login/phone")
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_PHONE,
            consumes = SwaggerConstant.MEDIA_JSON, produces = SwaggerConstant.MEDIA_JSON,
            response = User.class
    )
    public Mono<User> loginByPhone(String phone) {
        return Mono.just(new User());
    }

    @PostMapping("login/email")
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_EMAIL,
            consumes = SwaggerConstant.MEDIA_JSON, produces = SwaggerConstant.MEDIA_JSON,
            response = User.class
    )
    public Mono<User> loginByEmail(String email) {
        return Mono.just(new User());
    }


    @PostMapping("login/third")
    @ApiOperation(
            value = SwaggerConstant.VALUE_LOGIN_THIRD,
            consumes = SwaggerConstant.MEDIA_JSON, produces = SwaggerConstant.MEDIA_JSON,
            response = User.class
    )
    public Mono<User> loginByThird(String token) {
        return Mono.just(new User());
    }

}
```

2. ```User.java```

``` java
@Data
@ApiModel()
public class User {
   @ApiModelProperty(SwaggerConstant.PROPERTY_USER_ID)
   private String id;

   @ApiModelProperty(SwaggerConstant.PROPERTY_USER_NAME)
   private String name;
}
```

3. ```SwaggerConstant.java```
```java
public interface SwaggerConstant {

    String MEDIA_JSON = "application/json";

    String TAG_LOGIN = "登录接口";

    String VALUE_LOGIN_PASSWORD = "密码登录";

    String VALUE_LOGIN_PHONE = "手机验证码登录";

    String VALUE_LOGIN_EMAIL = "邮箱验证码登录";

    String VALUE_LOGIN_THIRD = "第三方登录";


    String PROPERTY_USER_ID ="用户id" ;

    String PROPERTY_USER_NAME = "用户名" ;
}
```
- 接口文档预览
运行项目，在浏览器中访问[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)查看接口文档。

![swagger preview](https://github.com/erzhiqianyi/yitian-blog/blob/master/image/swagger_pre.PNG?raw=true)

- 注解说明 

1.  ```Api```

给控制器添加标签信息，描述已经不推荐使用。建议给控制器添加该注解和tags，路由方法不需要再添tags。
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Api {
   String value() default "";

   String[] tags() default "";

   @Deprecated String description() default "";

   @Deprecated String basePath() default "";

   @Deprecated int position() default 0;

   String produces() default "";

   String consumes() default "";

   String protocols() default "";

   Authorization[] authorizations() default @Authorization(value = "");

   boolean hidden() default false;
}
```
2. ```ApiOperation```
描述接口,可以不添加tags,如果添加tags，会出现重复接口。
```java
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiOperation {
   // 接口描述
   String value();

   String notes() default "";
  // 分类标签
   String[] tags() default "";

  //返回数据类型
   Class<?> response() default Void.class;

   String responseContainer() default "";

   String responseReference() default "";

  //请求方法
   String httpMethod() default "";

   @Deprecated int position() default 0;

   String nickname() default "";

  //返回数据格式
   String produces() default "";

  //接收数据格式
   String consumes() default "";

  //协议
   String protocols() default "";

   Authorization[] authorizations() default @Authorization(value = "");

   boolean hidden() default false;

   ResponseHeader[] responseHeaders() default @ResponseHeader(name = "", response = Void.class);

   int code() default 200;

    Extension[] extensions() default @Extension(properties = @ExtensionProperty(name = "", value = ""));

   boolean ignoreJsonView() default false;
}
```
3. ```ApiModel```
描述涉及到的对象 
```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiModel {
   String value() default "";

   String description() default "";

   Class<?> parent() default Void.class;

   String discriminator() default "";

   Class<?>[] subTypes() default {};

    String reference() default "";
}
```
4. ```ApiModelProperty```
定义对象相关属性
```java
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiModelProperty {
   String value() default "";

   String name() default "";

   String allowableValues() default "";

   String access() default "";

   String notes() default "";

    String dataType() default "";

   boolean required() default false;

   int position() default 0;

   boolean hidden() default false;

   String example() default "";

   @Deprecated
    boolean readOnly() default false;

   AccessMode accessMode() default AccessMode.AUTO;


   String reference() default "";

   boolean allowEmptyValue() default false;

   Extension[] extensions() default @Extension(properties = @ExtensionProperty(name = "", value = ""));

    enum AccessMode {
        AUTO,
        READ_ONLY,
        READ_WRITE;
    }
}
```

