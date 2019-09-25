Mock.mock(/temTree|paraTree/, function () {

    return {
        dataList: [{
            parentId: null,
            id: 1,
            name: 'aa',
            children: [{
                parentId: 1,
                id: 11,
                name: 'ab',
                children: []
            }, {
                parentId: 1,
                id: 12,
                name: 'ab',
                children: [{
                    parentId: 12,
                    id: 121,
                    name: 'ab',
                    children: []
                }]
            }]
        }, {
            parentId: null,
            id: 2,
            name: 'aa',
            children: []
        }]
    }

});