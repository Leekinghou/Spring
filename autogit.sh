if [ ! $1 ]
then
  echo "####### 请输入分支名字 #######"
  exit;
fi

if [ ! $2 ]
then
  echo "####### 请输入commit值 #######"
  exit;
fi

echo "开始执行命令"

git add .

git status

# 写个sleep 1s 是为了解决并发导致卡壳

sleep 1s

echo "####### 添加文件 #######"

# 表情
emoji_array=(':zap: ' ':fire: ' ':rocket:' ':robot:' ':hankey:' ':truck:' ':alien:')
# shellcheck disable=SC2128
set -- $emoji_array
# shellcheck disable=SC2046
shift $(expr $RANDOM % $#)
# shellcheck disable=SC2034
emoji="$1"

git commit -m "emoji $2"

sleep 1s

echo "####### 拉取远程最新代码 #######"

git checkout master

git pull

sleep 3s

git checkout "$1"

echo "####### 本地合并代码 #######"

git merge master

echo "####### 开始推送 #######"

git push origin master "$1"


